package com.henryxi.core.util.concurrent.queue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    protected BlockingQueue<String> blockingQueue;

    public Consumer(BlockingQueue<String> queue) {
        this.blockingQueue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (blockingQueue.size() >= 7) {
                    Thread.sleep(100);
                } else {
                    Thread.sleep(1500);
                }
                System.out.println("consume:" + blockingQueue.take() + ", total:" + blockingQueue.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}