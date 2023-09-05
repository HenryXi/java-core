package com.henryxi.core.util.collection.list;

import java.util.ArrayList;
import java.util.List;

public class TestListToString {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a0");
        list.add("a1");
        list.add("a2");
        list.add("a3");
        System.out.println(list.toString());
    }
}
