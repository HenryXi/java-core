package com.henryxi.thread.mainchild;

public class Child extends Thread {
    @Override
    public void run(){
        System.out.println("child thread start");
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("child thread end");
    }
}
