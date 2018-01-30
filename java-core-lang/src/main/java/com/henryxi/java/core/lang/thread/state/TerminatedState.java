package com.henryxi.java.core.lang.thread.state;

public class TerminatedState implements ThreadState {
    @Override
    public void printStateInfo() {
        Thread terminated = new Thread();
        terminated.start();
        do {
            if (terminated.getState().equals(Thread.State.TERMINATED)) {
                System.out.println("terminated state:" + Thread.State.TERMINATED);
                break;
            }
        } while (true);
    }
}
