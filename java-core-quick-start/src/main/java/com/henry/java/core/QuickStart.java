package com.henry.java.core;

public class QuickStart {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("old style");
            }
        };

        Runnable lambdaRunnable = () -> System.out.println("hello Lambda!");
        runnable.run();
        lambdaRunnable.run();
    }
}
