package com.henryxi.thread;

public class multiThreadAlternateExecute {
    private static Object lock = new Object();
    private static boolean flag;

    public static void main(String[] args) {
        Thread a = new Thread() {
            public void run() {
                while (true) {
                    synchronized (lock) {
                        if (flag) {
                            flag = false;
                            for (int i = 0; i < 3; i++) {
                                System.out.println("a execute");
                            }
                            lock.notify();
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        };
        Thread b = new Thread() {
            public void run() {
                while (true) {
                    synchronized (lock) {
                        if (!flag) {
                            flag = true;
                            for (int i = 0; i < 3; i++) {
                                System.out.println("b execute");
                            }
                            lock.notify();
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        };
        a.start();
        b.start();
    }
}
