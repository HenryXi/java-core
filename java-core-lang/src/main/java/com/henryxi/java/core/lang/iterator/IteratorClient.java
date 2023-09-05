package com.henryxi.java.core.lang.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorClient {
    public static void main(String[] args) throws Exception {
        List<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        strings.add("5");
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            String value = iterator.next();
            try {
                if (value.equals("4")) {
                    iterator.remove();
                }
                throw new Exception();
            } catch (Exception e) {

            }

        }
        System.out.println(strings);
    }
}
