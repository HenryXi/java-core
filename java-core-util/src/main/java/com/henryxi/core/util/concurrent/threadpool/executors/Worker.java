package com.henryxi.core.util.concurrent.threadpool.executors;

import java.util.concurrent.Callable;

public class Worker implements Callable<ThreadInfo> {
    private String workerName;

    public Worker(String workerName) {
        this.workerName = workerName;
    }

    @Override
    public ThreadInfo call() throws Exception {
        Thread.sleep(10);
        ThreadInfo threadInfo = new ThreadInfo();
        threadInfo.setWorkerName(workerName);
        threadInfo.setThreadName(Thread.currentThread().getName());
        return threadInfo;
    }
}
