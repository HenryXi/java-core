# Java ForkJoinPool example
`ForkJoinPool` is used to handle the big task which can split into small tasks. I will show you how to use `ForkJoinPool`
and `RecursiveTask` in this page. Let's say you want to calculate the sum from 1 to 1,000,000,000. There are two ways to 
calculate. The first way: calculate directly. The second way: split 1,000,000,000 numbers into different groups and calculate 
them in different thread then adding their respective results together.
`ForkJoinPool` can help you to use different threads 

The example code is here.
```java
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

public class ForkJoinTaskClient {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
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
```
The output is here. Comparing with calculating directly it's more efficient to use `ForkJoinPool` for a big task.
```
compute directly result:500000000500000000, use time in millisecond:326
compute forkjoin result:500000000500000000, use time in millisecond:122
```
EOF