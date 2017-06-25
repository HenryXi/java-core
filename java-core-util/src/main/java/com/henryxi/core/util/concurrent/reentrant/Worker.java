package com.henryxi.core.util.concurrent.reentrant;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Worker {
    private static Lock lock = new ReentrantLock();

    private static int count = 0;

    public void execute(long time) {
        Thread thread = Thread.currentThread();
        lock.lock();
        System.out.println("this is: " + thread.getName() + " current count:" + count++);
        lock.unlock();
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
