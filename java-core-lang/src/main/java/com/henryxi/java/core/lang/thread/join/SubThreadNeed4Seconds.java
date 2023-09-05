package com.henryxi.java.core.lang.thread.join;

public class SubThreadNeed4Seconds extends Thread {
    public SubThreadNeed4Seconds(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " sub thread start");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " sub thread end");
    }
}
