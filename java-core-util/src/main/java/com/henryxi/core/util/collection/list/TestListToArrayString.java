package com.henryxi.core.util.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestListToArrayString {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("abaa");
        list.add("1aaa");
        list.add("a3aa");
        Collections.sort(list);
        System.out.println(Arrays.toString(list.toArray()));
    }
}
