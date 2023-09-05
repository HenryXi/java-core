package com.henryxi.core.util.concurrent.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierActionClient {
    public static void main(String[] args) {
        int workerNum = 4;
        CyclicBarrier barrier = new CyclicBarrier(workerNum, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " say: all tasks execute finish");
            }
        });
        for (int i = 0; i < workerNum; i++) {
            new Thread(new Worker(barrier)).start();
        }
        System.out.println("submit tasks finish");
    }
}
