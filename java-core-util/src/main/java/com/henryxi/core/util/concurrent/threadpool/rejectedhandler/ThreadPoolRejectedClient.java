package com.henryxi.core.util.concurrent.threadpool.rejectedhandler;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolRejectedClient {
    public static void main(String args[]) throws InterruptedException {
        System.out.println("pool/queue/active/completed");
        RejectedHandler rejectionHandler = new RejectedHandler();
        ThreadPoolExecutor executorPool = new ThreadPoolExecutor(2, 4, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2), Executors.defaultThreadFactory(), rejectionHandler);
        for (int i = 0; i < 15; i++) {
            printExecutorInfo(executorPool);
            if (i > 10) {
                Thread.sleep(3000);
            }
            executorPool.execute(new Worker("worker" + i));
        }
        Thread.sleep(6000);
        executorPool.shutdown();
    }

    private static void printExecutorInfo(ThreadPoolExecutor executor) throws InterruptedException {
        System.out.println(executor.getPoolSize() + "/" + executor.getQueue().size() + "/"
                + executor.getActiveCount() + "/" + executor.getCompletedTaskCount());
    }
}
