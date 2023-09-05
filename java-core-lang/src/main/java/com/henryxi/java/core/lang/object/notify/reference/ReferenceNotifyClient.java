package com.henryxi.java.core.lang.object.notify.reference;

public class ReferenceNotifyClient {
    private static Object lock = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            Object reference = lock;
            try {
                synchronized (lock) {
                    System.out.println("thread1 will wait");
                    reference.wait();
                    System.out.println("thread1 finish wait");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            synchronized (lock) {
                System.out.println("thread1 will notify");
                lock.notify();
                System.out.println("thread1 finish notify");
            }
        }).start();
    }
}
