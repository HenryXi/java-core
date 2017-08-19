package com.henryxi.core.util.collection.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilterClient {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("henry", 28));
        users.add(new User("justin", 27));
        users.add(new User("Mathew", 26));
        users.stream().filter(user -> user.getName().equals("")).collect(Collectors.toList());
    }
}
