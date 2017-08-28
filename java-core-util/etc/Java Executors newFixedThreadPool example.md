# Java Executors newFixedThreadPool example
`Executors.newFixedThreadPool(3)` method will create a thread pool with only 3 threads. When we put `Runnable`
or `Callable` object into the thread pool. The thread pool will create new thread for running task. When the 
number of threads equals the pool size the new task will be queued. The code below may help you have a better 
understanding of the the method `newFixedThreadPool()`.
 
```java
public class NewFixedThreadPoolClient {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Set<String> workersName = new HashSet<>();
        Set<String> threadsName = new HashSet<>();
        ThreadPoolExecutor pool = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        List<Future<ThreadInfo>> futureList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Worker t1 = new Worker("Thread " + i);
            Future<ThreadInfo> future = pool.submit(t1);
            futureList.add(future);
        }
        for (Future<ThreadInfo> future : futureList) {
            System.out.println("queue size:" + pool.getQueue().size());
            ThreadInfo threadInfo = future.get();
            workersName.add(threadInfo.getWorkerName());
            threadsName.add(threadInfo.getThreadName());
        }
        System.out.println("workers num:" + workersName.size());
        System.out.println("threads num:" + threadsName.size());
        pool.shutdown();
    }
}

public class ThreadInfo {
    private String threadName;
    private String workerName;

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }
}

public class Worker implements Callable<ThreadInfo> {
    private String workerName;

    public Worker(String workerName) {
        this.workerName = workerName;
    }

    @Override
    public ThreadInfo call() throws Exception {
        Thread.sleep(10);
        ThreadInfo threadInfo = new ThreadInfo();
        threadInfo.setWorkerName(workerName);
        threadInfo.setThreadName(Thread.currentThread().getName());
        return threadInfo;
    }
}
```
The output is like following. As you can see the size of queue is reducing. This means when submit new tasks 
they will be queued. when previous tasks are finished thread pool will execute next tasks. At last, the workers 
size is 100 and the threads size is 3. That means there are 100 workers created but only 3 threads to execute the tasks.
```
queue size:97
queue size:94
queue size:94
queue size:94
queue size:93
queue size:91
queue size:91
queue size:89
queue size:88
queue size:88
queue size:87
queue size:85
queue size:85
queue size:82
queue size:82
queue size:82
queue size:80
queue size:79
queue size:79
queue size:77
queue size:76
queue size:76
queue size:74
queue size:73
queue size:73
queue size:70
queue size:70
queue size:70
queue size:67
queue size:67
queue size:67
queue size:64
queue size:64
queue size:64
queue size:61
queue size:61
queue size:61
queue size:58
queue size:58
queue size:58
queue size:56
queue size:55
queue size:55
queue size:53
queue size:52
queue size:52
queue size:49
queue size:49
queue size:49
queue size:46
queue size:46
queue size:46
queue size:45
queue size:43
queue size:43
queue size:40
queue size:40
queue size:40
queue size:37
queue size:37
queue size:37
queue size:34
queue size:34
queue size:34
queue size:32
queue size:31
queue size:31
queue size:30
queue size:28
queue size:28
queue size:25
queue size:25
queue size:25
queue size:22
queue size:22
queue size:22
queue size:19
queue size:19
queue size:19
queue size:19
queue size:16
queue size:16
queue size:13
queue size:13
queue size:13
queue size:10
queue size:10
queue size:10
queue size:8
queue size:7
queue size:7
queue size:5
queue size:4
queue size:4
queue size:1
queue size:1
queue size:1
queue size:0
queue size:0
queue size:0
workers num:100
threads num:3
```

EOF