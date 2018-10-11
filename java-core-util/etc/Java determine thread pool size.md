# Java determine thread pool size
You may have used `ThreadPoolExecutor` to submit some task and waiting for the result. In this way program can get the better
performance. The question is how to calculate the size of pool size, in other words how to make CPU 100% or close to 100% 
busy?
```
N_t = N_c * U_c *(1 + W/C)
```
`N_t`: the number of threads.
`N_c`: the number of CPU cores.
`U_c`: CPU usage.
`W/C`: CPU waiting time/CPU busy time.
Here is a task.
```java
public class Task {

    public void doTask() {
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
```
The output is here.
```
get loop times cost time:1000
calculate cost time:23082
total time:24082
```
From the output we can know CPU waiting time is 1 second and CPU busy time is 23 second. So the W/C = 1/23. My computer 
use I7 CPU which have 8 cores. If we want CPU 50% busy the number of thread is: 8 * 50% (1+1/23) ≈ 4.

Let's verify this result. Refactor `Task` to implement `Runnable` and submit 4 task to thread pool. The code is here. 
```java
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

public class ThreadPoolSizeClient {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
        for (int i = 0; i < 30; i++) {
            executor.submit(new RunnableTask());
        }
    }
}
```
Run the main method in `ThreadPoolSizeClient` and open task manager(I use windows) you can see the usage of CPU is close
to 50%. How to make CPU usage as 100% just change the size of thread pool to 8.(don't do this, 100% CPU usage will make 
your computer suspended animation )

EOF