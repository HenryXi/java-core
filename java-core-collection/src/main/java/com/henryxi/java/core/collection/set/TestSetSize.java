package com.henryxi.java.core.collection.set;

import java.util.HashSet;
import java.util.Set;

public class TestSetSize {
    public static void main(String[] args) {
        Set<String> stringSet = new HashSet<>(10);
        for (int i = 0; i < 100; i++) {
            stringSet.add("num " + i);
            System.out.println(stringSet);
        }
    }
}
