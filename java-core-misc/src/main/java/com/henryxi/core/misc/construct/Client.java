package com.henryxi.core.misc.construct;

public class Client {
    public static void main(String[] args) {
        new Child();
        System.out.println("----init second child----");
        new Child();
    }
}
