package com.henryxi.core.util.collection.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestSet {
    public static void main(String[] args) {
        Set<String> setStr = new HashSet<>();
        setStr.add("test1");
        setStr.add("test2");

        for (String target0 : setStr) {
            System.out.println(target0);
            break;
        }

        String target1 = (String) setStr.toArray()[0];
        System.out.println(target1);

        List<String> listStr = new ArrayList<>();
        listStr.addAll(setStr);
        String target2 = listStr.get(0);
        System.out.println(target2);

        String target3 = setStr.iterator().next();
        System.out.println(target3);
    }
}
