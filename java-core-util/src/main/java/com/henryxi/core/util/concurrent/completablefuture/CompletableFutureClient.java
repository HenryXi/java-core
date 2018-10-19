package com.henryxi.core.util.concurrent.completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import static java.util.stream.Collectors.toList;

public class CompletableFutureClient {

    private static ContentService contentService = new ContentService();
    private static AuthorService authorService = new AuthorService();

    public static void main(String[] args) {
        List<Integer> contentsId = Arrays.asList(6, 8, 9, 66, 18, 99, 68, 89, 100, 166);
        normalStream(contentsId);
        parallelStream(contentsId);
        completableFutureStream(contentsId);
        completableFutureStreamWithExecutors(contentsId);
    }

    private static void normalStream(List<Integer> contentsId) {
        long beginTime = System.currentTimeMillis();
        List<Author> authorList = contentsId.stream()
                .map(i -> contentService.getContent(i))
                .map(a -> authorService.getAuthor(a.getAuthorId()))
                .collect(toList());
        long endTime = System.currentTimeMillis();
        System.out.println("normalStream cost:" + (endTime - beginTime) + ", authors size:" + authorList.size());
    }

    private static void parallelStream(List<Integer> contentsId) {
        long beginTime = System.currentTimeMillis();
        List<Author> authorList = contentsId.stream().parallel()
                .map(i -> contentService.getContent(i))
                .map(a -> authorService.getAuthor(a.getAuthorId()))
                .collect(toList());
        long endTime = System.currentTimeMillis();
        System.out.println("parallelStream cost:" + (endTime - beginTime) + ", authors size:" + authorList.size());
    }

    private static void completableFutureStream(List<Integer> contentsId) {
        long beginTime = System.currentTimeMillis();
        List<CompletableFuture<Author>> authorsFutures = contentsId.stream()
                .map(i -> CompletableFuture.supplyAsync(() -> contentService.getContent(i)))
                .map(future -> future.thenCompose(content -> CompletableFuture.supplyAsync(() -> authorService.getAuthor(content.getAuthorId()))))
                .collect(toList());
        List<Author> authorList = authorsFutures.stream().map(CompletableFuture::join).collect(toList());
        long endTime = System.currentTimeMillis();
        System.out.println("completableFutureStream cost:" + (endTime - beginTime) + ", authors size:" + authorList.size());
    }

    private static void completableFutureStreamWithExecutors(List<Integer> contentsId) {
        final Executor executor =
                Executors.newFixedThreadPool(Math.min(contentsId.size(), 100), r -> {
                    Thread t = new Thread(r);
                    t.setDaemon(true);
                    return t;
                });
        long beginTime = System.currentTimeMillis();
        List<CompletableFuture<Author>> authorsFutures = contentsId.stream()
                .map(i -> CompletableFuture.supplyAsync(() -> contentService.getContent(i), executor))
                .map(future -> future.thenCompose(content -> CompletableFuture.supplyAsync(() -> authorService.getAuthor(content.getAuthorId()), executor)))
                .collect(toList());
        List<Author> authorList = authorsFutures.stream().map(CompletableFuture::join).collect(toList());
        long endTime = System.currentTimeMillis();
        System.out.println("completableFutureStreamWithExecutors cost:" + (endTime - beginTime) + ", authors size:" + authorList.size());
    }
}
