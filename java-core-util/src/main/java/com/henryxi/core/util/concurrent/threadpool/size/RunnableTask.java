package com.henryxi.core.util.concurrent.threadpool.size;

public class RunnableTask implements Runnable {

    private int getLoopTimes() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 10000000;
    }

    private int calculate(int outsideLoopTime) {
        int result = 0;
        for (int i = 0; i < outsideLoopTime; i++) {
            for (int j = 0; j < 1000; j++) {
                result = result + 1;
                result = result - 1;
                result = result * 10;
                result = result / 10;
            }
        }
        return result + 100;
    }

    @Override
    public void run() {
        int loopTimes = getLoopTimes();
        calculate(loopTimes);
        System.out.println("finish");
    }
}
