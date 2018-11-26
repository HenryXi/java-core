package com.henryxi.core.util.collection.list;

import java.util.Arrays;
import java.util.List;

public class SubListClient {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println(list.subList(0, 5));
    }
}
