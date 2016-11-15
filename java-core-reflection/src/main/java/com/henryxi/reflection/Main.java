package com.henryxi.reflection;

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        Class clazz = client.getClass();
        System.out.println(clazz);
    }
}
