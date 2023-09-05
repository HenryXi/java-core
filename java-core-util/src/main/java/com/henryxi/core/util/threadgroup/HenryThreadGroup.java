package com.henryxi.core.util.threadgroup;

public class HenryThreadGroup extends ThreadGroup {
    public void uncaughtException(Thread t, Throwable ex) {
        System.err.println("I caught " + ex);
    }

    public HenryThreadGroup(String name) {
        super(name);
    }
}
