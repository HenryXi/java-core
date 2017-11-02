package com.henryxi.core.util.collection.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Client {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "Henry"));
        userList.add(new User(2, "Justin"));

        Map<Integer, User> map = new HashMap<>();
        for (User user : userList) {
            map.put(user.getId(), user);
        }
        System.out.println(map);


        Map<Integer, User> mapByStream = userList.stream().collect(Collectors.toMap(User::getId, user -> user));
        System.out.println(mapByStream);

        Map<Integer, User> mapByConverter = Converter.convertListToMap(userList, User::getId);
        System.out.println(mapByConverter);


    }
}
