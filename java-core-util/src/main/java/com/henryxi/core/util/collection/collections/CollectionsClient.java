package com.henryxi.core.util.collection.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsClient {
    public static void main(String[] args) {
        List<String> unmodifiableList = Collections.unmodifiableList(Arrays.asList("aa", "bb"));
        String s = unmodifiableList.get(0);
        System.out.println(s);
    }
}
