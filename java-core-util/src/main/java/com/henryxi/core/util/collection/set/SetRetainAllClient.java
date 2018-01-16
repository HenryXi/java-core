package com.henryxi.core.util.collection.set;

import java.util.HashSet;
import java.util.Set;

public class SetRetainAllClient {
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();
        set1.add("2056438719");
        set1.add("3514067829");
        set1.add("7621438950");
        set1.add("9850124763");
        Set<String> set2 = new HashSet<>();
        set2.add("3514067829");
        set2.add("9850124763");
        set1.retainAll(set2);
        System.out.println(set1);
    }
}
