package com.henry.java.core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Loop {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("username1","comment1"));
        users.add(new User("username2","comment2"));
        users.add(new User("username3","comment3"));
        List<User> userList = users.stream().collect(Collectors.toList());
    }
}
