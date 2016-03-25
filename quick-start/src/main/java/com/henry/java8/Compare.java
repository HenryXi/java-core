package com.henry.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Compare {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("username1", "comment1"));
        userList.add(new User("username2", "comment3"));
        Collections.sort(userList, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getUsername().compareTo(o2.getUsername());
            }
        });

        Collections.sort(userList, (user1, user2) -> user1.getUsername().compareTo(user2.getUsername()));
    }
}
