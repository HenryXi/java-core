package com.henryxi.java.core.collection.util;

import com.google.common.base.Function;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Client {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        Map<String, User> mappedRoles = Maps.uniqueIndex(userList, new Function<User, String>() {
            public String apply(User from) {
                return from.getName(); // or something else
            }
        });
    }

    //todo write convert method by own
}
