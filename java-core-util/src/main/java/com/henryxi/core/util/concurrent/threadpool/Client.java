package com.henryxi.core.util.concurrent.threadpool;

import com.henryxi.core.util.concurrent.threadpool.simple.Worker;

import java.util.concurrent.*;

public class Client {
    public static void main(String args[]) throws InterruptedException {
        //RejectedExecutionHandler implementation
        RejectedHandler rejectionHandler = new RejectedHandler();
        //Get the ThreadFactory implementation to use
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        //creating the ThreadPoolExecutor
        ThreadPoolExecutor executorPool = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2), threadFactory, rejectionHandler);
        //start the monitoring thread
        Monitor monitor = new Monitor(executorPool, 3);
        Thread monitorThread = new Thread(monitor);
        monitorThread.start();
        //submit work to the thread pool
        for (int i = 0; i < 10; i++) {
            executorPool.execute(new Worker("cmd" + i));
        }

        Thread.sleep(30000);
        //shut down the pool
        executorPool.shutdown();
        //shut down the monitor thread
        Thread.sleep(5000);
        monitor.shutdown();

    }
}
