package com.henryxi.java.core.lang.thread.notify;

public class Business {
    private boolean isMainThread = true;

    public synchronized void sub(int i) {
        while (!isMainThread) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int j = 1; j <= 10; j++) {
            System.out.println("sub thread sequence of " + j + ",loop of " + i);
        }
        isMainThread = false;
        this.notify();
    }

    public synchronized void main(int i) {
        while (isMainThread) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int j = 1; j <= 100; j++) {
            System.out.println("main thread sequence of " + j + ",loop of " + i);
        }
        isMainThread = true;
        this.notify();
    }
}
