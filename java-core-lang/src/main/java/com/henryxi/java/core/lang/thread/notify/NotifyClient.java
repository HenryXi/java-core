package com.henryxi.java.core.lang.thread.notify;

public class NotifyClient {
    public static void main(String[] args) {

        final Business business = new Business();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 50; i++) {
                    business.sub(i);
                }

            }
        }).start();

        for (int i = 1; i <= 50; i++) {
            business.main(i);
        }
    }
}

