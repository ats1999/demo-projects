package org.example;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import org.apache.zookeeper.*;
import org.example.zoo.Executor;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Main implements Watcher {
    static Logger logger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        logger.setLevel(Level.ERROR);

        Main m1 = new Main();
        ZooKeeper zk1 = new ZooKeeper("localhost:2181",3000,m1);
        zk1.addWatch("/test", AddWatchMode.PERSISTENT);

        Main m2 = new Main();
        ZooKeeper zk2 = new ZooKeeper("localhost:2181",3000,m2);
        zk2.addWatch("/test", AddWatchMode.PERSISTENT);

//        zk2.removeAllWatches("/test",WatcherType.Any,false);
        while (true){
            Thread.sleep(100);
        }
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        String path = watchedEvent.getPath();
        Event.KeeperState state = watchedEvent.getState();
        Event.EventType type = watchedEvent.getType();

        System.out.println("Path: " + path);
        System.out.println("State: " + state);
        System.out.println("Type: " + type);
    }
}