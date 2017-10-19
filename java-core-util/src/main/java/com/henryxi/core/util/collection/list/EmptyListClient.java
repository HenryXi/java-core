package com.henryxi.core.util.collection.list;

import java.util.ArrayList;
import java.util.List;

public class EmptyListClient {
    public static void main(String[] args) {
        List<String> emptyList = new ArrayList<>();
        for (String v : emptyList) {
            System.out.println(v);
        }
        System.out.println("done");
    }
}
