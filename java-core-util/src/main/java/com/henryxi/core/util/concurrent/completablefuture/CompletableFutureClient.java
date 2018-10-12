package com.henryxi.core.util.concurrent.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class CompletableFutureClient {
    public static void main(String[] args) {
        Future<Integer> resultAsync1 = getResultAsync();
        Future<Integer> resultAsync2 = getResultAsync();
    }

    private static Future<Integer> getResultAsync() {
        return CompletableFuture.supplyAsync(CompletableFutureClient::getInt);
    }

    private static int getInt() {
        CostLongTimeTask costLongTimeTask = new CostLongTimeTask();
        return costLongTimeTask.costLongTimeDoSomething();
    }
}
