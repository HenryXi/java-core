package com.henryxi.core.util.locks;

public class ReadThread extends Thread{
    private Cache cache;

    public ReadThread(Cache cache) {
        this.cache = cache;
    }

    @Override
    public void run() {
        do{
            cache.read();
        }while (true);
    }
}
