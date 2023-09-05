package com.henryxi.java.core.lang.threadlocal;

public class ThreadLocalClient {
    private ThreadLocal<Boolean> threadLocal = ThreadLocal.withInitial(() -> false);

    public static void main(String[] args) {
        ThreadLocalClient client = new ThreadLocalClient();
        boolean first = client.getValue();
        System.out.println(first);
        client.setTrue();
        boolean second = client.getValue();
        System.out.println("first:" + first + ",second:" + second);
    }

    public boolean getValue() {
        return threadLocal.get();
    }

    public void setTrue() {
        threadLocal.set(true);
    }
}
