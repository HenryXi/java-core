package com.henryxi.core.util.collection.list.filter;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class FilterClient {
    public static void main(String[] args) {
        List<String> originList = Arrays.asList("a", "b", "c", "d", "e");
        List<String> filterList = Arrays.asList("b", "c", "d", "f");

        List<String> afterFilter = originList.stream().filter(filterList::contains).collect(toList());
        System.out.println("after filter:" + afterFilter);
    }
}
