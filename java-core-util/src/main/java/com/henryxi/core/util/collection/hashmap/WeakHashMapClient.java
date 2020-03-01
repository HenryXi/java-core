package com.henryxi.core.util.collection.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapClient {
    public static void main(String[] args) {
        Map<String,String> hashMap= new HashMap<>();

        Map<String,String> weakHashMap = new WeakHashMap<>();

        String keyInHashMap = new String("keyInHashMap");
        String keyInWeakHashMap = new String("keyInWeakHashMap");

        hashMap.put(keyInHashMap, "ValueInHashMap");
        weakHashMap.put(keyInWeakHashMap, "ValueInWeakHashMap");
        System.gc();
        System.out.println("Before: hash map value:"+hashMap.get("keyInHashMap")+" and weak hash map value:"+weakHashMap.get("keyInWeakHashMap"));

        keyInHashMap = null;
        keyInWeakHashMap = null;

        System.gc();

        System.out.println("After: hash map value:"+hashMap.get("keyInHashMap")+" and weak hash map value:"+weakHashMap.get("keyInWeakHashMap"));
    }

}
