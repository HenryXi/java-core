package com.henryxi.java.core.lang.thread.state;

public class RunnableState implements ThreadState {
    private static volatile boolean stillRunning = true;

    @Override
    public void printStateInfo() {
        Thread startState = new Thread() {
            @Override
            public void run() {
                int i = 0;
                do {

                } while (stillRunning);
            }
        };
        startState.start();
        System.out.println("runnable state:" + startState.getState());
        stillRunning = false;
    }
}
