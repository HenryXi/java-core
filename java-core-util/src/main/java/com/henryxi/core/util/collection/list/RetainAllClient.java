package com.henryxi.core.util.collection.list;

import java.util.ArrayList;
import java.util.List;

public class RetainAllClient {
    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        a.add("1");
        a.add("2");
        a.add("3");
        a.add("4");
        List<String> b = new ArrayList<>();
        b.add("1");
        b.add("2");
        b.add("4");
        b.add("5");
        System.out.println(a.retainAll(b));
        System.out.println(a);
        System.out.println(b);
    }
}
