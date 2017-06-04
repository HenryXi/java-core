package com.henryxi.java.core.collection.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Client {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "Henry"));
        userList.add(new User(2, "Justin"));

        Map<Object, User> mapByStream = userList.stream().collect(Collectors.toMap(User::getId, User -> User));
        System.out.println(mapByStream);

        Map<Object, User> mapByConverter = Converter.convertListToMap(userList, User::getId);
        System.out.println(mapByConverter);


    }
}
