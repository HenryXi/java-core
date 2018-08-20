package com.henryxi.core.util.stream.collectors;

import com.henryxi.core.util.stream.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsGroupingByClient {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("henry", 30));
        users.add(new User("justin", 30));
        users.add(new User("mathew", 27));
        oldGroupingBy(users);
        newGroupingBy(users);
    }

    private static void newGroupingBy(List<User> users) {
        Map<Integer, List<User>> ageUsersMap = users.stream().collect(Collectors.groupingBy(User::getAge));
        System.out.println("age users map:" + ageUsersMap);

        Map<Integer, Long> ageCountMap = users.stream().collect(Collectors.groupingBy(User::getAge, Collectors.counting()));
        System.out.println("age count map:" + ageCountMap);
    }

    private static void oldGroupingBy(List<User> users) {
        Map<Integer, List<User>> ageUsersMap = new HashMap<>();
        for (User user : users) {
            List<User> groupOfUser = ageUsersMap.get(user.getAge());
            if (groupOfUser != null) {
                groupOfUser.add(user);
                continue;
            }
            groupOfUser = new ArrayList<>();
            groupOfUser.add(user);
            ageUsersMap.put(user.getAge(), groupOfUser);
        }
        System.out.println("age users map:" + ageUsersMap);
    }
}
