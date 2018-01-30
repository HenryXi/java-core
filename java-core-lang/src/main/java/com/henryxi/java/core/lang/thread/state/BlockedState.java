package com.henryxi.java.core.lang.thread.state;

public class BlockedState implements PrintThreadState {
    private static volatile boolean still_running = true;

    @Override
    public void print() {

        Thread blockState1 = new Thread(this::syncMethod);
        blockState1.start();
        Thread blockState2 = new Thread(this::syncMethod);
        blockState2.start();
        do {
            if (blockState1.getState().equals(Thread.State.BLOCKED)) {
                System.out.println("block state:" + Thread.State.BLOCKED);
                break;
            }
            if (blockState2.getState().equals(Thread.State.BLOCKED)) {
                System.out.println("block state:" + Thread.State.BLOCKED);
                break;
            }
        } while (true);
        still_running = false;
    }

    private synchronized void syncMethod() {
        do {

        } while (still_running);
    }
}
