package com.henryxi.core.util.collection.set;

import java.util.*;

public class AddAllTest {
    public static void main(String[] args) {
        Set<String> targetSet = new HashSet<>();
        List<String> tobeAddList = new ArrayList<>();
        if (tobeAddList != null) {
            targetSet.addAll(tobeAddList);
            targetSet.add("a");
        }
        tobeAddList.contains(null);
        Optional.ofNullable(tobeAddList).ifPresent(targetSet::addAll);
        System.out.println(targetSet);
    }
}
