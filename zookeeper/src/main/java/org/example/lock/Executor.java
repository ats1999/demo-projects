package org.example.lock;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class Executor implements Runnable {
    private final String connectionString;
    private final int connectionTimeout;
    private final String LOCK_PATH;
    private String lockPath;
    ZooKeeper zk;

    Executor(String connectionString, int connectionTimeout, String lockPath) {
        this.connectionString = connectionString;
        this.connectionTimeout = connectionTimeout;
        this.LOCK_PATH = lockPath;
    }

    public void createLockNode() throws InterruptedException, KeeperException {
        if (zk.exists(LOCK_PATH, false) != null) {
            return;
        }

        try{
            zk.create(LOCK_PATH, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }catch (Exception ex){
            // noop - node already exist
        }
    }

    boolean acquireLock() throws InterruptedException, KeeperException {
        if(this.lockPath == null) {
            this.lockPath = this.zk.create(LOCK_PATH + "/", new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        }

        List<String> children = zk.getChildren(LOCK_PATH,false);
        Collections.sort(children);
        String smallestChild = children.get(0);
        return this.lockPath.endsWith(smallestChild);
    }

    void releaseLock() throws InterruptedException, KeeperException {
        zk.delete(this.lockPath, -1);
        this.lockPath = null;
    }

    public void doTask(int task) throws InterruptedException, KeeperException {
        long oneSecond = Duration
                .ofSeconds(1)
                .toMillis();

        while (!this.acquireLock()) {
            Thread.sleep(oneSecond);
        }

        System.out.println("Lock acquired: "+Thread.currentThread().getName());
        Thread.sleep(oneSecond); // busy processing simulation
        this.releaseLock();
        System.out.println("Lock released: "+Thread.currentThread().getName());
    }

    public void doProcessing() throws InterruptedException, KeeperException {
        for (var task = 0; task < 10; task++) {
            doTask(task);
        }
    }

    @Override
    public void run() {
        try {
            // create zookeeper client
            zk = new Zk(connectionString, connectionTimeout)
                    .createZkClient();

            // create a lock node if it does not exist already
            this.createLockNode();
        } catch (IOException | InterruptedException | KeeperException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        try {
            doProcessing();
        } catch (InterruptedException | KeeperException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
