package com.henryxi.core.misc.operator.mod;

import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.toList;

public class ModClient {
    public static void main(String[] args) {
        List<Integer> list = new Random().ints(100, 0, 100).boxed().collect(toList());
        list.forEach(i -> System.out.println(i % 10));
    }
}
