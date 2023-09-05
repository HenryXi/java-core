package com.henryxi.core.util.concurrent.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Worker implements Runnable {

    private CyclicBarrier cyclicBarrier;

    public Worker(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println("thread " + Thread.currentThread().getName() + " is doing something...");
        try {
            Thread.sleep(5000);
            System.out.println("thread " + Thread.currentThread().getName() + " finish work, waiting for other threads.");
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("thread "+Thread.currentThread().getName()+" wake up: other threads finish work");
    }
}
