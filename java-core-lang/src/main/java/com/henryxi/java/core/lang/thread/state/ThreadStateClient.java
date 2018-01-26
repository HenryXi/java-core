package com.henryxi.java.core.lang.thread.state;

public class ThreadStateClient {
    private static volatile boolean stillRunning = true;
    private static volatile int blockState = 0;
    private static volatile boolean blockStateRunning = true;
    private static final Object monitor = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread newState = new Thread();
        System.out.println("new state:" + newState.getState());

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

        Thread blockState1 = new Thread() {
            @Override
            public void run() {
                try {
                    do {
                        synchronized (monitor) {
                            if (blockState < 100) {
                                blockState++;
                            } else {
                                monitor.wait();
                            }
                        }
                    } while (blockStateRunning);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        blockState1.start();
        Thread blockState2 = new Thread() {
            @Override
            public void run() {
                try {
                    do {
                        synchronized (monitor) {
                            if (blockState > 100) {
                                blockState--;
                            } else {
                                monitor.wait();
                            }
                        }
                    } while (blockStateRunning);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }  
        };
        blockState2.start();
        do {
            if (blockState < 100) {
                System.out.println("block state:" + blockState1.getState());
                blockStateRunning = false;
            }
        } while (true);
    }
}
