package com.henryxi.java.core.lang.thread.deadlock;

public class DeadlockClient {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();
        Worker1 worker1 = new Worker1(lock1, lock2);
        Worker2 worker2 = new Worker2(lock1, lock2);
        worker1.start();
        worker2.start();
    }
}
