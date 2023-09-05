package com.henryxi.core.util.stream.collectors;

import com.henryxi.core.util.stream.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectorsPartitioningByClient {
    public static void main(String[] args) {
        Map<Boolean, List<Integer>> evenMap = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println(evenMap);

        List<User> users = new ArrayList<>();
        users.add(new User("Henry", 30));
        users.add(new User("Justin", 27));
        users.add(new User("Mathew", 26));
        Map<Boolean, List<User>> biggerThan30Map = users.stream().collect(Collectors.partitioningBy(u -> u.getAge() >= 30));
        System.out.println(biggerThan30Map);
    }
}
