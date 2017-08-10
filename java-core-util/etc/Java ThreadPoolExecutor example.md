# Java ThreadPoolExecutor example
`ThreadPoolExecutor` is a useful class to manage threads in JDK. Create a thread task and put it to thread pool. This
task will be executed in the feature. The simple thread pool code is here.

**Worker**
```java
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

**ThreadPoolClient**
```java
public class ThreadPoolClient {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        for (int i = 0; i < 10; i++) {
            Runnable worker = new Worker("worker" + i);
            executor.execute(worker);
        }
        executor.shutdown();
        while (true) {
            if (executor.isTerminated()) {
                break;
            }
        }
        System.out.println("all workers finish");
    }
}
```

The output is like following.
```
worker0 start, probably need 7048 millisecond
worker1 start, probably need 8450 millisecond
worker2 start, probably need 1279 millisecond
worker3 start, probably need 3772 millisecond
worker4 start, probably need 4447 millisecond
worker2 finish
worker5 start, probably need 603 millisecond
worker5 finish
worker6 start, probably need 6717 millisecond
worker3 finish
worker7 start, probably need 725 millisecond
worker4 finish
worker8 start, probably need 4806 millisecond
worker7 finish
worker9 start, probably need 4536 millisecond
worker0 finish
worker1 finish
worker6 finish
worker9 finish
worker8 finish
all workers finish
```

EOF