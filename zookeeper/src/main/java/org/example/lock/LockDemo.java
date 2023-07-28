package org.example.lock;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

public class LockDemo {
    static Logger logger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
    public static void main(String[] args) {
        logger.setLevel(Level.ERROR);
        String connectionString="localhost:2181";
        int connectionTimeout = 3000;
        String lockPath = "/distributed-lock.json";

        int executorsCount = 10;

        for(int i=0; i<executorsCount; i++){
            Executor executor = new Executor(connectionString,connectionTimeout,lockPath);
            new Thread(executor).start();
        }
    }
}
