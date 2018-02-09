package com.henryxi.core.util.locks;

public class WriteThread extends Thread {
    private Cache cache;

    public WriteThread(Cache cache) {
        this.cache = cache;
    }

    @Override
    public void run() {
        try {
            do {
                cache.update();
                Thread.sleep(1000 * 5);
            } while (true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
