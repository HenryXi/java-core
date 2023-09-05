package com.henryxi.core.util.concurrent.future;

import java.util.concurrent.Callable;

class Task implements Callable<String> {
    public String call() throws Exception {
        System.out.println("this is task class , I am running");
        Thread.sleep(2000);
        System.out.println("this is task class , I am stopping");
        return "task result";
    }
}