package com.henryxi.core.util.stream.parallel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParallelStreamClient {
//    static int l = 0;---> no need to count times.

    public static void main(String[] args) throws java.lang.Exception {
        letsGoParallel();
    }

    public static int makeSomeMagic(int data) {
//        l++;-----> this is no thread-say way
        return data * 100;
    }

    public static void letsGoParallel() {
        List<Integer> dataList = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            dataList.add(i);
        }
        Map<Integer, Integer> resultMap = dataList.parallelStream().collect(Collectors.toMap(i -> i, ParallelStreamClient::makeSomeMagic));
        System.out.println("Input Size: " + dataList.size());
        System.out.println("Size: " + resultMap.size());
//        System.out.println("Function Called: " + l);
    }
}
