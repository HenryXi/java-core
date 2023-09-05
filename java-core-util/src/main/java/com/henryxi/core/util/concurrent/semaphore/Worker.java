package com.henryxi.core.util.concurrent.semaphore;

import java.util.concurrent.Semaphore;

public class Worker implements Runnable {
    private int num;
    private Semaphore semaphore;

    public Worker(int num, Semaphore semaphore) {
        this.num = num;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println("thread" + this.num + " acquire a computer...");
            Thread.sleep(2000);
            System.out.println("thread" + this.num + " release the computer");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
