package com.henryxi.core.util.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamPeekClient {
    public static void main(String[] args) {
        List<Integer> integerList = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
        int sum = integerList.stream()
                .peek(i -> System.out.println("origin:" + i))
                .mapToInt(i -> i + 1)
                .peek(i -> System.out.println("processed:" + i)).sum();
        System.out.println("sum:" + sum);
    }
}
