package com.henryxi.core.util.concurrent.threadpool.executors;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class NewCachedThreadPoolClient {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Set<String> workersName = new HashSet<>();
        Set<String> threadsName = new HashSet<>();
        ExecutorService pool = Executors.newCachedThreadPool();
        List<Future<ThreadInfo>> futureList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Worker t1 = new Worker("Thread " + i);
            Future<ThreadInfo> future = pool.submit(t1);
            futureList.add(future);
        }
        for (Future<ThreadInfo> future : futureList) {
            ThreadInfo threadInfo = future.get();
            workersName.add(threadInfo.getWorkerName());
            threadsName.add(threadInfo.getThreadName());
        }
        System.out.println("workers num:" + workersName.size());
        System.out.println("threads num:" + threadsName.size());
        pool.shutdown();
    }
}
