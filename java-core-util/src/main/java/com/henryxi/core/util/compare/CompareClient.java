package com.henryxi.core.util.compare;

import java.util.*;

public class CompareClient {
    public static void main(String[] args) {
        List<ComparableUser> comparableUsers = new LinkedList<>();
        comparableUsers.add(new ComparableUser("Henry", 27));
        comparableUsers.add(new ComparableUser("Justin", 26));
        comparableUsers.add(new ComparableUser("Charles", 32));
        System.out.println("before sorted:" + comparableUsers);
        Collections.sort(comparableUsers);
        System.out.println("after sorted:" + comparableUsers);

        List<User> userList = new LinkedList<>();
        userList.add(new User("Henry", 27));
        userList.add(new User("Justin", 26));
        userList.add(new User("Charles", 32));
        System.out.println("before sorted:" + userList);
        Collections.sort(userList, (o1, o2) -> (o1.getAge() < o2.getAge()) ? -1 : ((o1.getAge() == o2.getAge()) ? 0 : 1));
        System.out.println("after sorted:" + userList);

        Set<ComparableUser> userSet = new TreeSet<>();
        userSet.add(new ComparableUser("Henry", 27));
        userSet.add(new ComparableUser("Justin", 26));
        userSet.add(new ComparableUser("Charles", 32));
        System.out.println(userSet);
    }
}
