package com.henryxi.java.core.lang.thread.deadlock;

public class Worker1 extends Thread {
    private final Object lock1;
    private final Object lock2;

    public Worker1(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        while (true){
            synchronized (lock1) {
                System.out.println(currentThread().getName()+" get lock1");
                synchronized (lock2) {
                    System.out.println(currentThread().getName()+" get lock2");
                }
                System.out.println(currentThread().getName()+" release lock2");
            }
            System.out.println(currentThread().getName()+" release lock1");
        }
    }
}
