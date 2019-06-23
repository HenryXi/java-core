package com.henryxi.core.util.concurrent.completablefuture.concurrence;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CompletableFutureConcurrenceCodeFormatClient {
    private static final Executor executor =
            Executors.newFixedThreadPool(600, r -> {
                Thread t = new Thread(r);
                t.setDaemon(true);
                return t;
            });

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long beginTime = System.currentTimeMillis();
        String userName = "henry";
        UserInfo userInfo = new UserInfo();
        CompletableFuture<Void> addressFuture = CompletableFuture.runAsync(() -> assembleAddress(userName, userInfo), executor);
        CompletableFuture<Void> companyNameFuture = CompletableFuture.runAsync(() -> assembleCompany(userName, userInfo), executor);
        CompletableFuture<Void> familyFuture = CompletableFuture.runAsync(() -> assembleFamilyInfo(userName, userInfo), executor);
        CompletableFuture.allOf(addressFuture, companyNameFuture, familyFuture).join();
        System.out.println("user info: " + userInfo + "\r\ntime cost:" + (System.currentTimeMillis() - beginTime));
    }

    private static void assembleCompany(String userName, UserInfo userInfo) {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        userInfo.setCompanyName("my_company");
    }

    private static void assembleAddress(String userName, UserInfo userInfo) {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        userInfo.setAddress("beijing");
    }

    private static void assembleFamilyInfo(String userName, UserInfo userInfo) {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        userInfo.setFamilyInfo("wife and son");
    }
}
