package com.henryxi.core.util.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PartitioningByClient {
    public static void main(String[] args) {
        Map<Boolean, List<Integer>> evenMap = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println(evenMap);
    }

}
