package com.henryxi.core.misc.construct.static_field;

public class Client {
    public static void main(String[] args) {
        Child.getInstance();
        System.out.println("----get instance second time----");
        Child.getInstance();
    }
}
