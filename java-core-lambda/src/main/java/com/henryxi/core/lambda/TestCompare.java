package com.henryxi.core.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestCompare {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("username1", "comment1"));
        userList.add(new User("username2", "comment3"));
        Collections.sort(userList, (o1, o2) -> o1.getUsername().compareTo(o2.getUsername()));

        Collections.sort(userList, (user1, user2) -> user1.getUsername().compareTo(user2.getUsername()));
    }

}
