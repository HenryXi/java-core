package com.henryxi.core.util.concurrent.threadpool.executors;

import java.util.concurrent.Callable;

public class WorkerForSingle implements Callable<ThreadInfo> {
    private String workerName;

    public WorkerForSingle(String workerName) {
        this.workerName = workerName;
    }

    @Override
    public ThreadInfo call() throws Exception {
        Thread.sleep(10);
        if (Integer.valueOf(workerName.substring(7)) % 10 == 0) {
            System.out.println("current thread terminate.");
            Thread.interrupted();
        }
        System.out.println(workerName + " is working..");
        ThreadInfo threadInfo = new ThreadInfo();
        threadInfo.setWorkerName(workerName);
        threadInfo.setThreadName(Thread.currentThread().getName());
        return threadInfo;
    }
}
