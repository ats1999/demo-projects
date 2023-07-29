package org.example.lock;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

public class DefaultWatcher implements Watcher {
    private final Object watchLock;

    DefaultWatcher(Object watchLock) {
        this.watchLock = watchLock;
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getType() == Event.EventType.NodeDeleted) {
            synchronized (this.watchLock) {
                this.watchLock.notify();
            }
        }
    }
}
