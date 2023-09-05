package com.henryxi.core.util.concurrent.threadpool.size;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolSizeClient {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(8);
        for (int i = 0; i < 30; i++) {
            executor.submit(new RunnableTask());
        }
    }
}
