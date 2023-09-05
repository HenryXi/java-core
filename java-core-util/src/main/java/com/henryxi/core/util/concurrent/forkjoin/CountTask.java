package com.henryxi.core.util.concurrent.forkjoin;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class CountTask extends RecursiveTask<Long> {
    private static final int MIN_COUNT = 1_000_000;
    private long begin;
    private long end;

    public CountTask(long begin, long end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (end - begin < MIN_COUNT) {
            return computeDirectly();
        }
        long count = end - begin + 1;
        long parts = count / MIN_COUNT;
        List<CountTask> countTaskList = new LinkedList<>();
        for (int i = 1; i <= parts; i++) {
            int begin = MIN_COUNT * (i - 1) + 1;
            int end = MIN_COUNT * i;
            //System.out.println("task" + i + ", begin:" + begin + ", end:" + end);
            countTaskList.add(new CountTask(begin, end));
        }
        Collection<CountTask> countTasks = invokeAll(countTaskList);
        long sum = 0;
        for (CountTask task : countTasks) {
            sum = sum + task.join();
        }
        return sum;
    }

    private Long computeDirectly() {
        long sum = 0;
        do {
            sum = begin + sum;
            begin++;
        } while (begin <= end);
        return sum;
    }
}
