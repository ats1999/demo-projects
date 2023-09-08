package org.example.zoo;

import lombok.Builder;
import lombok.Data;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

@Data
@Builder
public class Executor implements Runnable, Watcher, DataMonitor.Listener {
    private String connectionString;
    private String zNode;
    int sessionTimeout;
    ZooKeeper zk;

    public void buildZkClient() throws IOException {
        zk = new ZooKeeper(
                this.connectionString,
                this.sessionTimeout,
                this
        );
    }

    @Override
    public void run() {
        try {
            zk.create("/lock/l-",null,ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT_SEQUENTIAL);
        } catch (KeeperException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            Stat s = zk.exists("/test",true);
            System.out.println("here.."+s);
        } catch (KeeperException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            zk.addWatch("/a/b/c", AddWatchMode.PERSISTENT_RECURSIVE);
        } catch (KeeperException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void exists(byte[] data) {

    }

    @Override
    public void closing(int rc) {
        synchronized (this) {
            notifyAll();
        }
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        String path = watchedEvent.getPath();
        Event.KeeperState state = watchedEvent.getState();
        Event.EventType type = watchedEvent.getType();
        byte[] data;
        try {
            data = zk.getData(path != null ? path : zNode, false, new Stat());
        } catch (KeeperException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Path: " + path);
        System.out.println("State: " + state);
        System.out.println("Type: " + type);
        System.out.println("Data: " + new String(data));
    }
}
