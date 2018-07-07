package com.henryxi.core.util.stream.collectors;

import com.henryxi.core.util.stream.User;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsToMapClient {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("henry", 28));
        users.add(new User("justin", 27));
        users.add(new User("Mathew", 26));
        Map<String, Integer> nameAgeMap = users.stream().collect(Collectors.toMap(User::getName, User::getAge));
        System.out.println(nameAgeMap);
        LinkedHashMap<String, Integer> nameAgeOrderMap = users.stream().collect(Collectors.toMap(User::getName, User::getAge, (u, v) -> {
            throw new IllegalStateException(String.format("Duplicate key %s", u));
        }, LinkedHashMap::new));
        System.out.println(nameAgeOrderMap);
    }
}
