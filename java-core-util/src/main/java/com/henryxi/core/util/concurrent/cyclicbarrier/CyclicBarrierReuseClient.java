package com.henryxi.core.util.concurrent.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierReuseClient {
    public static void main(String[] args) throws InterruptedException {
        int N = 4;
        CyclicBarrier barrier = new CyclicBarrier(N);
        for (int i = 0; i < N; i++) {
            new Thread(new Worker(barrier)).start();
        }
        Thread.sleep(20000);
        System.out.println("CyclicBarrier reuse");
        for (int i = 0; i < N; i++) {
            new Thread(new Worker(barrier)).start();
        }
    }
}
