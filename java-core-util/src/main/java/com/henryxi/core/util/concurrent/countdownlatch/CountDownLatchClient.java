package com.henryxi.core.util.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchClient {
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);

        new Thread(new Worker(latch)).start();
        new Thread(new Worker(latch)).start();
        try {
            System.out.println("waiting 2 threads..");
            latch.await();
            System.out.println("2 threads finish.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
