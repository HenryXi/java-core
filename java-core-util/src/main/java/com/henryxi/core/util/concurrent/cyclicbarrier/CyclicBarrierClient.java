package com.henryxi.core.util.concurrent.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierClient {
    public static void main(String[] args) {
        int workerNum = 4;
        CyclicBarrier barrier = new CyclicBarrier(workerNum);
        for (int i = 0; i < workerNum; i++) {
            new Thread(new Worker(barrier)).start();
        }
        System.out.println("submit tasks finish");
    }
}
