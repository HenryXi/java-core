package com.henryxi.core.util.stream.collectors.mapping;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsMappingClient {
    public static void main(String[] args) {
        User user1 = new User("henry", 30);
        User user2 = new User("justin", 29);
        User user3 = new User("mathew", 25);
        User user4 = new User("charles", 30);
        List<User> users = Arrays.asList(user1, user2, user3, user4);
        Map<Integer, List<User>> userMap = users.stream().collect(Collectors.groupingBy(User::getAge));
        System.out.println(userMap);

        Map<Integer, List<String>> userAgeNameMap = users.stream().collect(Collectors.groupingBy(User::getAge, Collectors.mapping(User::getName, Collectors.toList())));
        System.out.println(userAgeNameMap);
    }
}
