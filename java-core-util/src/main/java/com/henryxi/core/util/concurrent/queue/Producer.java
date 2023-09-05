package com.henryxi.core.util.concurrent.queue;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    protected BlockingQueue<String> blockingQueue;

    public Producer(BlockingQueue<String> queue) {
        this.blockingQueue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String data = UUID.randomUUID().toString();
                blockingQueue.put(data);
                System.out.println("put in :" + data + ", total:" + blockingQueue.size());
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
