# Java Executors newCachedThreadPool example
`Executors.newCachedThreadPool()` method will create a thread pool which core pool size is 0 and max pool size 
is `Integer.MAX_VALUE`. The detail of constructor function is here:
```java
new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
```
This thread pool will always create a thread when there is no thread for new tasks. It uses `SynchronousQueue` 
to queue the new tasks, that means new tasks will always be executed. I wrote the sample code to help me understand it.

**ThreadInfo** for recording the information of thread
```java
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
```

**Worker** 
```java
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

**NewCachedThreadPoolClient**
```java
public class NewCachedThreadPoolClient {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Set<String> workersName = new HashSet<>();
        Set<String> threadsName = new HashSet<>();
        ExecutorService pool = Executors.newCachedThreadPool();
        List<Future<ThreadInfo>> futureList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Worker t1 = new Worker("Thread " + i);
            Future<ThreadInfo> future = pool.submit(t1);
            futureList.add(future);
        }
        for (Future<ThreadInfo> future : futureList) {
            ThreadInfo threadInfo = future.get();
            workersName.add(threadInfo.getWorkerName());
            threadsName.add(threadInfo.getThreadName());
        }
        System.out.println("workers num:" + workersName.size());
        System.out.println("threads num:" + threadsName.size());
        pool.shutdown();
    }
}
```

The output in my environment:
```
workers num:1000
threads num:379
```
The output means 1000 tasks are submitted, but only 379 threads are created. Thread pool will reuse the alive 
thread to execute the new task. You can change the `Thread.sleep(10)` to make the task finish more quickly or 
slower. The slower task finished the more threads will be created.

EOF
