package com.henryxi.core.util.locks.reentrant.interrupt;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockInterruptiblyClient {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Thread thread1 = new Thread(() -> {
            lock.lock();
            try {
                for (int i = 0; i < 20; i++) {
                    System.out.println(i);
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                lock.unlock();
            }
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            try {
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                System.out.println("cannot acquire lock.");
                return;
            }
            try {
                System.out.println("get lock");
                for (int i = 0; i < 10; i++) {
                    System.out.println("t2:" + i);
                }
            } finally {
                lock.unlock();
            }
        });
        thread2.start();
        for (int i = 0; i < 100; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("main running...  " + 1);
                if (i == 6) {
                    thread2.interrupt();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
