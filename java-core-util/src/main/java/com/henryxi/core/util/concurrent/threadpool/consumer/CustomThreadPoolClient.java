package com.henryxi.core.util.concurrent.threadpool.consumer;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomThreadPoolClient {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(6, 50, 1L, TimeUnit.MINUTES, new LinkedBlockingQueue<>(10));
        do {
            int queueSize = threadPoolExecutor.getQueue().size();
            int poolSize = threadPoolExecutor.getPoolSize();
            System.out.println("queue size:" + queueSize + ",poolSize:" + poolSize);
            List<Integer> messageList;
            if (isAddiable(poolSize, queueSize) && (messageList = getMessage()).size() > 0) {
                threadPoolExecutor.submit(new Worker(messageList));
            }
        } while (true);
    }

    private static boolean isAddiable(int poolSize, int queueSize) {
        return poolSize < 50 || queueSize < 10;
    }

    private static List<Integer> getMessage() {
        Random random = new Random();
        List<Integer> randomNumbers = new LinkedList<>();
        for (int i = 0; i < random.nextInt(3); i++) {
            randomNumbers.add(6);
        }
        return randomNumbers;
    }
}
