# Understand ThreadPoolExecutor core and maximum
When we create `ThreadPoolExecutor` we need to specify the size of core and maximun. Let's say you create a executor,
the corePoolSize is 2, the maximumPoolSize is 4. In general, there are 2 threads working. If
the third task created it will be added in the queue. When the queue is full the executor will create a new thread
for handling the new task. New tasks will be rejected when the size of pool is equal with maximumPoolSize and
the queue is full.

The sample code is like following.

```java
public class ThreadPoolRejectedClient {
    public static void main(String args[]) throws InterruptedException {
        System.out.println("pool/queue/active/completed");
        RejectedHandler rejectionHandler = new RejectedHandler();
        ThreadPoolExecutor executorPool = new ThreadPoolExecutor(2, 4, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2), Executors.defaultThreadFactory(), rejectionHandler);
        for (int i = 0; i < 15; i++) {
            printExecutorInfo(executorPool);
            if (i > 10) {
                Thread.sleep(3000);
            }
            executorPool.execute(new Worker("worker" + i));
        }
        Thread.sleep(30000);
        executorPool.shutdown();
    }

    private static void printExecutorInfo(ThreadPoolExecutor executor) throws InterruptedException {
        System.out.println(executor.getPoolSize() + "/" + executor.getQueue().size() + "/"
                + executor.getActiveCount() + "/" + executor.getCompletedTaskCount());
    }
}

public class Worker extends Thread {

    private String name;
    private long timeCost;

    public Worker(String name) {
        this.name = name;
        this.timeCost = new Random().nextInt(10000);
    }

    @Override
    public void run() {
        System.out.println(this.toString() + " start, probably need " + timeCost + " millisecond");
        try {
            Thread.sleep(timeCost);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.toString() + " finish");
    }

    @Override
    public String toString() {
        return this.name;
    }
}
```

output:
```
pool/queue/active/completed
0/0/0/0
1/0/1/0
worker0 start, need 5 second.
2/0/2/0                     # New task will be executed, queue empty
worker1 start, need 5 second.
2/1/2/0                     # More task added, won't be executed put into queue instead
2/2/2/0                         
3/2/3/0                     # More task added, queue is full, executed new task
worker4 start, need 5 second.
4/2/4/0
worker5 start, need 5 second.
worker6 is rejected         # More task added, there is no space for them in queue, rejected!
4/2/4/0
worker7 is rejected
4/2/4/0
worker8 is rejected
4/2/4/0
worker9 is rejected
4/2/4/0
worker10 is rejected
4/2/4/0
worker11 is rejected
4/2/4/0
worker4 finish
worker0 finish
worker2 start, need 5 second.# Executed tasks in queue
worker1 finish
worker5 finish
worker3 start, need 5 second.
2/1/2/4                     # Tasks handled, the thread pool size reduce
2/2/2/4
worker2 finish
worker12 start, need 5 second.
worker3 finish
worker13 start, need 5 second.
worker12 finish
worker14 start, need 5 second.
worker13 finish
worker14 finish
```