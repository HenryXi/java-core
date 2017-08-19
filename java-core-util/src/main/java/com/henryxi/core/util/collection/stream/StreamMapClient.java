package com.henryxi.core.util.collection.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMapClient {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("henry", 28));
        users.add(new User("justin", 27));
        users.add(new User("Mathew", 26));
        List<Integer> ages = users.stream().map(User::getAge).collect(Collectors.toList());
        List<String> names = users.stream().map(User::getName).collect(Collectors.toList());
        System.out.println(ages);
        System.out.println(names);
    }
}
