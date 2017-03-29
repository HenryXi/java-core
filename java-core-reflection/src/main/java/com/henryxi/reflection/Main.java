package com.henryxi.reflection;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        Class clazz = user.getClass();
        System.out.println(clazz);
        System.out.println(Arrays.toString(clazz.getFields()));
    }
}
