package com.henryxi.core.util.collection.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupByClient {
    public static void main(String[] args) {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("KSID", 1);
        map1.put("JE", 200);
        map1.put("XM", "yong");
        Map<String, Object> map2 = new HashMap<>();
        map2.put("XM", "海芳");
        map2.put("KSID", 1);
        map2.put("JE", 300);

        Map<String, Object> map3 = new HashMap<>();
        map3.put("XM", "海芳");
        map3.put("KSID", 1);
        map3.put("JE", 500);

        Map<String, Object> map4 = new HashMap<>();
        map4.put("XM", "yong");
        map4.put("KSID", 1);
        map4.put("JE", 100);
        list.add(map1);
        list.add(map2);
        list.add(map3);
        list.add(map4);
        // 按照ksid和xm group by
        Map<String, Integer> resultMap = new HashMap<>();
        for (Map<String, Object> map : list) {
            String key = map.get("KSID") + "-" + map.get("XM");
            Integer value = (Integer) map.get("JE");
            resultMap.merge(key, value, (a, b) -> a + b);
        }
        System.out.println(resultMap);
    }
}
