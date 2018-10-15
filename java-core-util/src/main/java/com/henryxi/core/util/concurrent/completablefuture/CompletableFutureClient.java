package com.henryxi.core.util.concurrent.completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static java.util.stream.Collectors.toList;

public class CompletableFutureClient {

    private static ContentService contentService = new ContentService();
    private static AuthorService authorService = new AuthorService();

    public static void main(String[] args) {
        List<Integer> contentsId = Arrays.asList(6, 8, 9, 66, 18, 99);
        normalStream(contentsId);
        completableFutureStream(contentsId);
    }

    private static void normalStream(List<Integer> contentsId) {
        long beginTime = System.currentTimeMillis();
        List<Author> authorList = contentsId.stream()
                .map(i -> contentService.getContent(i))
                .map(a -> authorService.getAuthor(a.getAuthorId()))
                .collect(toList());
        long endTime = System.currentTimeMillis();
        System.out.println("normalStream cost:" + (endTime - beginTime) + ", authors:" + authorList);
    }

    private static void completableFutureStream(List<Integer> contentsId) {
        long beginTime = System.currentTimeMillis();
        List<CompletableFuture<Author>> authorsFutures = contentsId.stream()
                .map(i -> CompletableFuture.supplyAsync(() -> contentService.getContent(i)))
                .map(future -> future.thenCompose(content -> CompletableFuture.supplyAsync(() -> authorService.getAuthor(content.getAuthorId()))))
                .collect(toList());
        List<Author> authorList = authorsFutures.stream().map(CompletableFuture::join).collect(toList());
        long endTime = System.currentTimeMillis();
        System.out.println("completableFutureStream cost:" + (endTime - beginTime) + ", authors:" + authorList);
    }
}
