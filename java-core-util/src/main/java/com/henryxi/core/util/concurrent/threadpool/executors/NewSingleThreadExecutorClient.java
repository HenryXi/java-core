package com.henryxi.core.util.concurrent.threadpool.executors;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class NewSingleThreadExecutorClient {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Set<String> workersName = new HashSet<>();
        Set<String> threadsName = new HashSet<>();
        ExecutorService pool = Executors.newSingleThreadExecutor();
        List<Future<ThreadInfo>> futureList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            WorkerForSingle t1 = new WorkerForSingle("Thread " + i);
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
