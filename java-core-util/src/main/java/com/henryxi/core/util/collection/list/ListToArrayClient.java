package com.henryxi.core.util.collection.list;

import java.util.Arrays;
import java.util.List;

public class ListToArrayClient {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("1", "2", "3");
        System.out.println(list);
        String[] strings = list.toArray(new String[0]);
        print(strings);
    }

    private static void print(String... params) {
        for (String s : params) {
            System.out.println(s);
        }
    }
}
