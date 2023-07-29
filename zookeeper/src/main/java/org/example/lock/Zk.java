package org.example.lock;

import org.apache.zookeeper.ZooKeeper;
import java.io.IOException;

public class Zk {
    private final String connectionString;
    private final int connectionTimeout;
    private final Object watchLock;

    Zk(String connectionString, int connectionTimeout, Object watchLock){
        this.connectionString = connectionString;
        this.connectionTimeout = connectionTimeout;
        this.watchLock = watchLock;
    }

    ZooKeeper createZkClient() throws IOException {
        DefaultWatcher watcher = new DefaultWatcher(this.watchLock);
        return new ZooKeeper(connectionString, connectionTimeout, watcher);
    }
}
