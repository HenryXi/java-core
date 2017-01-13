package com.henryxi.java.core.collection.set;

import java.util.LinkedHashSet;

public class TestLinkedHashSet {
    public static void main(String[] args) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        for (int i = 0; i < 100; i++) {
            linkedHashSet.add("num " + i);
            if (linkedHashSet.size() > 10) {
                linkedHashSet.remove(linkedHashSet.iterator().next());
            }
            System.out.println(linkedHashSet);
        }
    }
}
