package com.henryxi.core.util.ojbects;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ObjectsNonNullClient {
    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(1, 2, 3, null);
        ints.stream().filter(Objects::nonNull).forEach(System.out::println);
    }
}
