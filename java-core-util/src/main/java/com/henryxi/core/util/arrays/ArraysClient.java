package com.henryxi.core.util.arrays;

import java.util.Arrays;
import java.util.List;

public class ArraysClient {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("test", "test1");
        strings.remove("test");
        System.out.println(strings);
    }
}
