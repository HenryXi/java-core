package com.henryxi.thread.mainchild;

public class MainThread {
    public static void main(String[] args) {
        System.out.println("main thread start");
        Child child = new Child();
        child.start();
        System.out.println("main thread end");
    }
}
