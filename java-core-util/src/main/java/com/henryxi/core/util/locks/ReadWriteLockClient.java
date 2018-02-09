package com.henryxi.core.util.locks;

public class ReadWriteLockClient {
    public static void main(String[] args) {
        Cache cache = new Cache();
        for (int i = 0; i < 2; i++) {
            new ReadThread(cache).start();
        }
        new WriteThread(cache).start();
    }
}
