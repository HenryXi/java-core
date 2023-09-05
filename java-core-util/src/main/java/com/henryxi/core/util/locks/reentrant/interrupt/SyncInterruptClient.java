package com.henryxi.core.util.locks.reentrant.interrupt;

import java.util.concurrent.TimeUnit;

public class SyncInterruptClient {
    public static void main(String[] args) {
        Object o = new Object();
        Thread thread1 = new Thread(() -> {

            synchronized (o) {
                while (true) {
//                    System.out.println("this is thread1");
                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            synchronized (o) {
                while (true) {
                    System.out.println("this is thread2");
                }
            }
        });
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.interrupt();
        for (int i = 0; i < 100; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("main running... " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
