package com.henryxi.core.util.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class StreamReduceClient {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(6, 5, 8, 9, 63, 36, 83, 85, 86, 96);
        Integer sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println("sum:" + sum);

        Integer max = numbers.stream().reduce(-1, Integer::max);
        System.out.println("max:" + max);

        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        System.out.println("min:" + min.orElse(-1));
    }
}
