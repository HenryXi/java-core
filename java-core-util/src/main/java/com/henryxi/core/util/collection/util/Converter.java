package com.henryxi.core.util.collection.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class Converter {
    public static <K, V> Map<K, V> convertListToMap(List<V> list, Function<V, K> function) {
        Map<K, V> map = new HashMap<>();
        for (V v : list) {
            map.put(function.apply(v), v);
        }
        return map;
    }
}
