package com.henryxi.java.core.lang.thread.daemon;

public class MyThread implements Runnable {

    @Override
    public void run() {
        while (true){
            System.out.println("luck");
        }
    }
}
