# Java CyclicBarrier example
`CyclicBarrier` is a tool class in concurrent package. It is used to make the thread waiting for other threads.
All threads will be waked up when they are all in "wait" state. The sample code is here.

**Worker**
```java
public class Worker implements Runnable {

    private CyclicBarrier cyclicBarrier;

    public Worker(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println("thread " + Thread.currentThread().getName() + " is doing something...");
        try {
            Thread.sleep(5000);
            System.out.println("thread " + Thread.currentThread().getName() + " finish work, waiting for other threads.");
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("thread "+Thread.currentThread().getName()+" wake up: other threads finish work");
    }
}
```

**1.block current thread until all thread finish**
```java
public class CyclicBarrierClient {
    public static void main(String[] args) {
        int workerNum = 4;
        CyclicBarrier barrier = new CyclicBarrier(workerNum);
        for (int i = 0; i < workerNum; i++) {
            new Thread(new Worker(barrier)).start();
        }
        System.out.println("submit tasks finish");
    }
}
```
output
```
thread Thread-0 is doing something...
thread Thread-1 is doing something...
submit tasks finish
thread Thread-2 is doing something...
thread Thread-3 is doing something...
thread Thread-0 finish work, waiting for other threads.
thread Thread-1 finish work, waiting for other threads.
thread Thread-2 finish work, waiting for other threads.
thread Thread-3 finish work, waiting for other threads.
thread Thread-3 wake up: other threads finish work
thread Thread-1 wake up: other threads finish work
thread Thread-2 wake up: other threads finish work
thread Thread-0 wake up: other threads finish work
```
**2.when all threads finish invoke callback method**

Define a `CyclicBarrier` with the implement of `Runnable` interface if you want do something after all threads 
finishing work.
```java
public class CyclicBarrierActionClient {
    public static void main(String[] args) {
        int workerNum = 4;
        CyclicBarrier barrier = new CyclicBarrier(workerNum, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " say: all tasks execute finish");
            }
        });
        for (int i = 0; i < workerNum; i++) {
            new Thread(new Worker(barrier)).start();
        }
        System.out.println("submit tasks finish");
    }
}
```
output
```
thread Thread-0 is doing something...
thread Thread-3 is doing something...
thread Thread-2 is doing something...
submit tasks finish
thread Thread-1 is doing something...
thread Thread-2 finish work, waiting for other threads.
thread Thread-3 finish work, waiting for other threads.
thread Thread-0 finish work, waiting for other threads.
thread Thread-1 finish work, waiting for other threads.
Thread-1 say: all tasks execute finish
thread Thread-1 wake up: other threads finish work
thread Thread-3 wake up: other threads finish work
thread Thread-2 wake up: other threads finish work
thread Thread-0 wake up: other threads finish work
```
**3.Reuse CyclicBarrier**

Comparing with `CountDownLatch` the advantage of `CyclicBarrier` is reusable. You can define 4 parties when define
`Cyclicbarrier` and create 8 threads. The barrier will be open when 4 threads are waiting and it will open again
 for next 4 waiting threads.
```java
public class CyclicBarrierReuseClient {
    public static void main(String[] args) throws InterruptedException {
        int N = 4;
        CyclicBarrier barrier = new CyclicBarrier(N);
        for (int i = 0; i < N; i++) {
            new Thread(new Worker(barrier)).start();
        }
//        Thread.sleep(25000);
        System.out.println("CyclicBarrier reuse");
        for (int i = 0; i < N; i++) {
            new Thread(new Worker(barrier)).start();
        }
    }
}
```
output
```
thread Thread-0 is doing something...
thread Thread-2 is doing something...
thread Thread-1 is doing something...
thread Thread-3 is doing something...
thread Thread-0 finish work, waiting for other threads.
thread Thread-3 finish work, waiting for other threads.
thread Thread-2 finish work, waiting for other threads.
thread Thread-1 finish work, waiting for other threads.
thread Thread-1 wake up: other threads finish work
thread Thread-2 wake up: other threads finish work
thread Thread-0 wake up: other threads finish work
thread Thread-3 wake up: other threads finish work
CyclicBarrier reuse
thread Thread-4 is doing something...
thread Thread-5 is doing something...
thread Thread-6 is doing something...
thread Thread-7 is doing something...
thread Thread-4 finish work, waiting for other threads.
thread Thread-5 finish work, waiting for other threads.
thread Thread-6 finish work, waiting for other threads.
thread Thread-7 finish work, waiting for other threads.
thread Thread-7 wake up: other threads finish work
thread Thread-4 wake up: other threads finish work
thread Thread-6 wake up: other threads finish work
thread Thread-5 wake up: other threads finish work
```

EOF