package com.henryxi.core.util.concurrent.threadpool.simple;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolClient {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        for (int i = 0; i < 10; i++) {
            Runnable worker = new Worker("worker" + i);
            executor.execute(worker);
        }
        executor.shutdown();
        while (true) {
            if (executor.isTerminated()) {
                break;
            }
        }
        System.out.println("all workers finish");
    }
}
