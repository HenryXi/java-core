package com.henryxi.java.core.lang.thread.daemon;

import java.util.LinkedList;
import java.util.List;

public class DaemonClient {
    public static void main(String[] args) {
        List<Thread> threadList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new MyThread());
            thread.setDaemon(true);
            threadList.add(thread);
        }
        threadList.forEach(Thread::start);
        System.out.println("main finish");
    }
}

