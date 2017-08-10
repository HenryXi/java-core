package com.henryxi.core.util.concurrent.threadpool.simple;

import java.util.Random;

public class Worker extends Thread {

    private String name;
    private long timeCost;

    public Worker(String name) {
        this.name = name;
        this.timeCost = new Random().nextInt(10000);
    }

    @Override
    public void run() {
        System.out.println(this.toString() + " start, probably need " + timeCost + " millisecond");
        try {
            Thread.sleep(timeCost);
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
