package com.henryxi.java.core.collection.list;

import java.util.ArrayList;
import java.util.List;

public class TestRemoveList {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list1.add("2");
        list1.add("3");
        List<String> list2 = new ArrayList<>();
        list2.add("1");
        list2.add("2");
        list1.removeAll(list2);
        System.out.println(list1);
    }
}
