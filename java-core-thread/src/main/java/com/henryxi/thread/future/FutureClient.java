package com.henryxi.thread.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureClient {
    public static void main(String[] args) throws Exception {
        Task task = new Task();
        ExecutorService es = Executors.newCachedThreadPool();
        Future future = es.submit(task);
        System.out.println("this is main thread, after submitting callable class. state of task:" + future.isDone());
        Thread.sleep(3000);
        System.out.println("this is main thread, after 3 seconds. state of task:" + future.isDone());
        Thread.sleep(2000);
        System.out.println("the result of task class:" + future.get());
        es.shutdownNow();
    }
}