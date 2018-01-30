package com.henryxi.java.core.lang.thread.state;

public class TimedWaiting implements ThreadState {
    @Override
    public void print() {
        Thread timedWaiting = new Thread(this::waitMethod);
        timedWaiting.start();
        do {
            if (timedWaiting.getState().equals(Thread.State.TIMED_WAITING)) {
                System.out.println("timedWaiting state:" + Thread.State.TIMED_WAITING);
                timedWaiting.interrupt();
                break;
            }
        } while (true);
    }

    private void waitMethod() {
        try {
            Thread.sleep(1000 * 60);
        } catch (InterruptedException e) {
            System.out.print("");
        }
    }
}
