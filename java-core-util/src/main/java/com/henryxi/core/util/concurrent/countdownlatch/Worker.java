package com.henryxi.core.util.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable {
    private CountDownLatch latch;

    public Worker(CountDownLatch countDownLatch) {
        this.latch= countDownLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println("thread:" + Thread.currentThread().getName() + " is running");
            Thread.sleep(3000);
            System.out.println("thread:" + Thread.currentThread().getName() + " is finish");
            latch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
