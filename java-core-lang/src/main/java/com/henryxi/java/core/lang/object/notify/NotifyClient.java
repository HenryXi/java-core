package com.henryxi.java.core.lang.object.notify;

public class NotifyClient {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        for (int i = 0; i < 10; i++) {
            new Thread(new Producer("producer" + i, warehouse)).start();
        }
        for (int i = 0; i < 10; i++) {
            new Thread(new Consumer("consumer" + i, warehouse)).start();
        }
    }
}

