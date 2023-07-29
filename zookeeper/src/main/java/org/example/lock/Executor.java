package org.example.lock;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class Executor implements Runnable {
    private final String connectionString;
    private final int connectionTimeout;
    private final String LOCK_PATH;
    private String lockPath;
    private ZooKeeper zk;
    private final Object watchLock;


    Executor(String connectionString, int connectionTimeout, String lockPath) {
        this.connectionString = connectionString;
        this.connectionTimeout = connectionTimeout;
        this.LOCK_PATH = lockPath;
        this.watchLock = new Object();
    }

    public void createLockNode() throws InterruptedException, KeeperException {
        if (zk.exists(LOCK_PATH, false) != null) {
            return;
        }

        try {
            zk.create(LOCK_PATH, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        } catch (Exception ex) {
            // noop - node already exist
        }
    }

    boolean acquireLock() throws InterruptedException, KeeperException {
        if (this.lockPath == null) {
            this.lockPath = this.zk.create(
                    LOCK_PATH + "/",
                    new byte[0],
                    ZooDefs.Ids.OPEN_ACL_UNSAFE,
                    CreateMode.EPHEMERAL_SEQUENTIAL
            );
        }

        List<String> children = zk.getChildren(LOCK_PATH, false);
        Collections.sort(children);
        String smallestChild = children.get(0);

        boolean isTrue = this.lockPath.endsWith(smallestChild);

        if (isTrue) {
            return true;
        }

        String curZNode = this.lockPath.replace(LOCK_PATH + "/", "");
        int watchZNodeIdx = children.indexOf(curZNode) - 1;

        while (watchZNodeIdx >= 0) {
            String watchZNode = children.get(watchZNodeIdx);
            String watchedZNodePath = LOCK_PATH + "/" + watchZNode;

            Stat exist = zk.exists(watchedZNodePath, true);

            // process that created zNode might have been disconnected
            // or, lock might have been released for watchedZNodePath
            if (exist == null) {
                zk.removeAllWatches(watchedZNodePath, Watcher.WatcherType.Any, false);
            } else {
                // returning false will make sure that current process will wait for watch event
                return false;
            }

            watchZNodeIdx--;
        }

        return false;
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
            synchronized (this.watchLock) {
                this.watchLock.wait();
            }
        }

        System.out.printf("Lock acquired for task %d by thread %s\n", task, Thread.currentThread().getName());
        Thread.sleep(oneSecond); // busy processing simulation
        this.releaseLock();
        System.out.printf("Lock released for task %d by thread %s\n", task, Thread.currentThread().getName());
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
            zk = new Zk(connectionString, connectionTimeout, this.watchLock)
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
