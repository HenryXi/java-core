package com.henryxi.core.util.collection.hashmap;

import java.util.HashMap;
import java.util.Map;

public class HashMapClient {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("1", 1);
        int i = map.get("1");
        i++;
        System.out.println(map.get("1"));
    }
}
