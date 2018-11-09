package com.henryxi.core.util.concurrent.completablefuture.timeout;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

public class CompletableFutureTimeoutClient {
    private static CPService cpService = new CPService();

    public static void main(String[] args) {
        List<Integer> contentsId = Arrays.asList(6, 8, 9, 66, 18, 99, 68, 89, 100, 166);
        List<CPFeed> collect = contentsId.stream()
                .map(i -> CompletableFuture.supplyAsync(() -> cpService.getCPFeed(i)))
                .map(future -> {
                    try {
                        return Optional.of(future.get(200, TimeUnit.MILLISECONDS));
                    } catch (InterruptedException | ExecutionException | TimeoutException e) {
                        e.printStackTrace();
                    }
                    return Optional.<CPFeed>empty();
                }).filter(Objects::nonNull).map(Optional::get).collect(Collectors.toList());
        for (CPFeed cpFeed : collect) {
            System.out.println(cpFeed.toString());
        }
    }
}
