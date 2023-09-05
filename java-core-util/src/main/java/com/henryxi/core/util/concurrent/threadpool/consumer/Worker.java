package com.henryxi.core.util.concurrent.threadpool.consumer;

import java.util.List;
import java.util.Random;

public class Worker implements Runnable {
    private List<Integer> messageList;

    private Worker() {
    }

    public Worker(List<Integer> messageList) {
        this.messageList = messageList;
    }

    @Override
    public void run() {
        System.out.println(messageList);
    }
}
