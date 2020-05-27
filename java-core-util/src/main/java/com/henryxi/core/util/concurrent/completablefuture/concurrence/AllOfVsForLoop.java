package com.henryxi.core.util.concurrent.completablefuture.concurrence;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AllOfVsForLoop {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(AllOfVsForLoop::longRun);
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(AllOfVsForLoop::longRun);
        CompletableFuture<Void> future3 = CompletableFuture.runAsync(AllOfVsForLoop::longRun);
        CompletableFuture.allOf(future1,future2,future3).join();
//        future1.get();
//        future2.get();
//        future3.get();
        System.out.println("used:" + (System.currentTimeMillis() - start));
    }

    public static void longRun() {
        try {
            Thread.sleep(5000);
            System.out.println("after run");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
