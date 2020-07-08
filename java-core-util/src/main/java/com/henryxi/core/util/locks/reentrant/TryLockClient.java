package com.henryxi.core.util.locks.reentrant;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockClient {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        new Thread(() -> {
            lock.lock();
            try {
                for (int i = 0; i < 2; i++) {
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
        }).start();

        new Thread(() -> {
            boolean isGetLock = false;
            try {
                isGetLock = lock.tryLock(3, TimeUnit.SECONDS);
                System.out.println("isGetLock:" + isGetLock);
                if (isGetLock) {
                    for (int i = 0; i < 10; i++) {
                        System.out.println("t2:" + i);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (isGetLock) {
                    System.out.println("unlock");
                    lock.unlock();
                }
            }
        }).start();
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("main running...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
