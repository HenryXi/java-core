package com.henryxi.core.util.concurrent.completablefuture.concurrence;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CompletableFutureConcurrenceClient {
    private static final Executor executor =
            Executors.newFixedThreadPool(600, r -> {
                Thread t = new Thread(r);
                t.setDaemon(true);
                return t;
            });

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long beginTime = System.currentTimeMillis();
        String userName = "henry";
        CompletableFuture<String> addressFuture = CompletableFuture.supplyAsync(() -> getAddress(userName));
        CompletableFuture<String> companyNameFuture = CompletableFuture.supplyAsync(() -> getCompanyName(userName));
        CompletableFuture<String> familyFuture = CompletableFuture.supplyAsync(() -> getFamilyInfo(userName));
        CompletableFuture<String> allInfoFuture = CompletableFuture.allOf(addressFuture, companyNameFuture, familyFuture)
                .thenApply(i -> {
                    String address = addressFuture.join();
                    String companyName = companyNameFuture.join();
                    String familyInfo = familyFuture.join();
                    return "userId:\t" + userName + " \r\n" + address + "\r\n" + companyName + "\r\n" + familyInfo;
                });
        String allInfo = allInfoFuture.get();
        System.out.println(allInfo + "\r\ntime cost:" + (System.currentTimeMillis() - beginTime));
    }

    private static String getCompanyName(String userName) {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userName + " company: \t my_company";
    }

    private static String getAddress(String userName) {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userName + " address: \t beijing";
    }

    private static String getFamilyInfo(String userName) {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userName + " family: \t wife and son";
    }
}
