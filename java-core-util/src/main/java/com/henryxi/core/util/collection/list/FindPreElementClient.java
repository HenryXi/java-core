package com.henryxi.core.util.collection.list;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class FindPreElementClient {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("element" + i);
        }
        System.out.println(list);
        ListIterator<String> it = list.listIterator();
        while (it.hasNext()) {
            String current = it.next();
            int previousIndex = it.previousIndex();
            if (current.equals("element1")) {
                System.out.println(list.get(previousIndex));
                return;
            }
        }
    }
}
