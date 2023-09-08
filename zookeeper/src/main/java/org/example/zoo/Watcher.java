package org.example.zoo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.ZooKeeper;

public class Watcher implements org.apache.zookeeper.Watcher {
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
