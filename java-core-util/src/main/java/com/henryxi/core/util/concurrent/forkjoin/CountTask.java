package com.henryxi.core.util.concurrent.forkjoin;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class CountTask extends RecursiveTask<Long> {

    private long begin;
    private long end;

    public CountTask(long begin, long end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (end - begin < 100_000) {
            return computeDirectly();
        }
        long count = end - begin + 1;
        long parts = count / 100_000;
        List<CountTask> countTaskList = new LinkedList<>();
        for (int i = 1; i <= parts; i++) {
            int begin = 100_000 * (i - 1) + 1;
            int end = 100_000 * i;
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
