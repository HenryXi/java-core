package com.henryxi.core.util.threadgroup;

public class ThreadGroupWorker {
    public void doWork() {
        ThreadGroup threadGroup = new HenryThreadGroup("henry's threads");
        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + " started");
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + " is working, output: " + i);
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException ex) {
                        System.out.println("interrupted exception");
                    }
                }
            }
        };
        for (int i = 0; i < 10; i++) {
            new Thread(threadGroup, runnable).start();
        }
        Thread[] list = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(list);
        for (int i = 0; i < list.length; i++) {
            if (list[i] == null) {
                continue;
            }
            Thread t = list[i];
            System.out.println(i + " group name: " + t.getThreadGroup().getName());
        }
    }
}
