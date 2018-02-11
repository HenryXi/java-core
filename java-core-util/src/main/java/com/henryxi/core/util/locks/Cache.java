package com.henryxi.core.util.locks;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Cache {
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock readLock = readWriteLock.readLock();
    private final Lock writeLock = readWriteLock.writeLock();
    private Random random = new Random();
    private int cacheValue;

    public Cache() {
        cacheValue = random.nextInt(100);
    }

    public void read() {
        try {
            readLock.lock();
            System.out.println("read thread unblocked,the value:" + cacheValue);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }

    public void update() {
        try {
            writeLock.lock();
            System.out.println("block all read thread for setting data to new value");
            Thread.sleep(5000);
            cacheValue = random.nextInt(100);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }
}
