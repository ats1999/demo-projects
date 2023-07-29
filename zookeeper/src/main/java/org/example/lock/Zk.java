package org.example.lock;

import org.apache.zookeeper.ZooKeeper;
import java.io.IOException;

public class Zk {
    private final String connectionString;
    private final int connectionTimeout;

    Zk(String connectionString, int connectionTimeout){
        this.connectionString = connectionString;
        this.connectionTimeout = connectionTimeout;
    }

    ZooKeeper createZkClient() throws IOException {
        RootWatcher watcher = new RootWatcher();
        return new ZooKeeper(connectionString, connectionTimeout, watcher);
    }
}
