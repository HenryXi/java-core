package com.henryxi.core.util.concurrent.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreClient {
    public static void main(String[] args) {
        int N = 8;
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < N; i++) {
            new Thread(new Worker(i, semaphore)).start();
        }
    }
}
