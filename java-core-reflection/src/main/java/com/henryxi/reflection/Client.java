package com.henryxi.reflection;

@SuppressWarnings("unchecked")
public class Client<T> extends SuperOfTarget<String> {
    public static void main(String[] args) {

        System.out.println(Client.class.getGenericSuperclass());
    }
}
