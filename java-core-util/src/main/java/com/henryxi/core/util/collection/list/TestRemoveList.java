package com.henryxi.core.util.collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestRemoveList {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add(null);
        list1.add(null);
        list1.add("2");
        list1.add("3");
        list1.remove(null);
        System.out.println(list1);//[null, 2, 3]

        List<String> list2 = new ArrayList<>();
        list2.add(null);
        list2.add(null);
        list2.add("2");
        list2.add("3");
        list2.removeAll(Collections.singletonList(null));
        System.out.println(list2);//[2, 3]
    }
}
