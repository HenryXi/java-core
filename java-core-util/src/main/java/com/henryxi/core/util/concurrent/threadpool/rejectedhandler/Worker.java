package com.henryxi.core.util.concurrent.threadpool.rejectedhandler;

public class Worker extends Thread {

    private String name;

    public Worker(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(this.toString() + " start, need 5 second.");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.toString() + " finish");
    }

    @Override
    public String toString() {
        return this.name;
    }
}
