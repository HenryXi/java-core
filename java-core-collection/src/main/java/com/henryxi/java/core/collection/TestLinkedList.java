package com.henryxi.java.core.collection;

import java.util.LinkedList;
import java.util.List;

public class TestLinkedList {
    public static void main(String[] args) throws InterruptedException {
        List<String> stringList = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            if (stringList.size() == 10) {
                stringList.remove(0);
            }
            stringList.add("num " + i);
            System.out.println(stringList);
        }

    }
}
