package com.henryxi.core.util.concurrent.copyonwritearraylist;

import java.util.ArrayList;
import java.util.List;

public class ConcurrentModificationArrayListClient {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();
        Thread subThread = new Thread(new Runnable() {
            int index = 0;

            @Override
            public void run() {
                while (true) {
                    list.add("index" + index);
                    index++;
                }
            }
        });
        subThread.start();
        Thread.sleep(1000);
        while (true) {
            System.out.println(list.toString());
        }
    }
}
