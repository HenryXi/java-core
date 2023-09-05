package com.henryxi.core.util.concurrent.threadpool.size;

public class Task {

    public static void main(String[] args) {
        Task task = new Task();
        task.doTask();
    }

    private void doTask() {
        long startTime = System.currentTimeMillis();
        int loopTimes = getLoopTimes();
        long getLoopTime = System.currentTimeMillis();
        calculate(loopTimes);
        long finishTime = System.currentTimeMillis();
        System.out.println("get loop times cost time:" + (getLoopTime - startTime));
        System.out.println("calculate cost time:" + (finishTime - getLoopTime));
        System.out.println("total time:" + (finishTime - startTime));

    }

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
}
