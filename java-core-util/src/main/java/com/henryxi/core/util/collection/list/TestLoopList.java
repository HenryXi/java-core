package com.henryxi.core.util.collection.list;

import java.util.ArrayList;
import java.util.List;

public class TestLoopList {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("name1", "beijing", 30));
        userList.add(new User("name2", "hebei", 21));
        userList.add(new User("name3", "tianjin", 25));
        userList.add(new User("name4", "shagnhai", 27));
        List<User> newUserList = modifyUser(userList);
        System.out.println(newUserList);
        System.out.println(userList);
    }

    private static List<User> modifyUser(List<User> users) {
        for (User user : users) {
            user.setName("new_name_" + user.getName());
        }
        return users;
    }
}
