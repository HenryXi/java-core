package com.henryxi.java.core.lang.thread.deadlock;

public class Worker2 extends Thread {
    private final Object lock1;
    private final Object lock2;

    public Worker2(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        while (true){
            synchronized (lock2) {
                System.out.println(currentThread().getName()+" get lock2");
                synchronized (lock1) {
                    System.out.println(currentThread().getName()+" get lock1");
                }
                System.out.println(currentThread().getName()+" release lock1");
            }
            System.out.println(currentThread().getName()+" release lock2");
        }
    }
}
