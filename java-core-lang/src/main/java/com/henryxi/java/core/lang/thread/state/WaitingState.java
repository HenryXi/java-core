package com.henryxi.java.core.lang.thread.state;

public class WaitingState implements ThreadState {

    private final Object monitor = new Object();

    @Override
    public void printStateInfo() {
        Thread waitingThread = new Thread(this::waitMethod);
        waitingThread.start();
        do {
            if (waitingThread.getState().equals(Thread.State.WAITING)) {
                System.out.println("waiting state:" + Thread.State.WAITING);
                notifyMethod();
                break;
            }
        } while (true);
    }

    private void waitMethod() {
        synchronized (monitor) {
            try {
                monitor.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void notifyMethod() {
        synchronized (monitor) {
            monitor.notifyAll();
        }
    }
}
