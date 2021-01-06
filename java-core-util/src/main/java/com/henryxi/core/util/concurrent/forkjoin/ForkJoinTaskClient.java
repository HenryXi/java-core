package com.henryxi.core.util.concurrent.forkjoin;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinTaskClient {
    public static void main(String[] args) {
        long begin = 1;
        long end = 1_000_000_000L;
        long directlyBeginTime = System.currentTimeMillis();
        Long directlyResult = computeDirectly(begin, end);
        long directlyEndTime = System.currentTimeMillis();
        System.out.println("compute directly result:" + directlyResult + ", use time in millisecond:" + (directlyEndTime - directlyBeginTime));

        long forkJoinBeginTime = System.currentTimeMillis();
        Long forkJoinResult = computeForkJoin(begin, end);
        long forkJoinEndTime = System.currentTimeMillis();
        System.out.println("compute forkjoin result:" + forkJoinResult + ", use time in millisecond:" + (forkJoinEndTime - forkJoinBeginTime));

    }

    private static long computeForkJoin(long begin, long end) {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        return forkJoinPool.invoke(new CountTask(begin, end));
    }

    private static Long computeDirectly(long begin, long end) {
        long sum = 0;
        do {
            sum = begin + sum;
            begin++;
        } while (begin <= end);
        return sum;
    }
}
