package com.henryxi.thread.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Client {
    public static void main(String[] args) {
        final BlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>(15);

        Producer queueProducer = new Producer(linkedBlockingQueue);
        new Thread(queueProducer).start();

        Consumer queueProducer2 = new Consumer(linkedBlockingQueue);
        new Thread(queueProducer2).start();

        Consumer queueConsumer = new Consumer(linkedBlockingQueue);
        new Thread(queueConsumer).start();
    }
}
