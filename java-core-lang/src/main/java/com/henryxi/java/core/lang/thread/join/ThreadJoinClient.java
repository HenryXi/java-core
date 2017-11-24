package com.henryxi.java.core.lang.thread.join;

public class ThreadJoinClient {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main thread start");
        Thread t1 = new SubThreadNeed4Seconds("t1");
        t1.start();
        System.out.println("main thread wait t1 finish");
        t1.join();
        System.out.println("main thread after t1.join()");
        Thread t2 = new SubThreadNeed4Seconds("t2");
        t2.start();
        System.out.println("main thread wait t2 1 second, if t2 not finish continue");
        t2.join(1000);
        System.out.println("main thread after t2.join(1000)");
    }
}
