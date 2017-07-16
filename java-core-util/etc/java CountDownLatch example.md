# Java CountDownLatch example
In java, if you want do something after multiple threads finish `CountDownLatch` might help you. This class can
 help you count how many threads is finished. If there is no thread running it will week up the main thread.
The code example is like following.
```java
public class Worker implements Runnable {
    private CountDownLatch latch;

    public Worker(CountDownLatch countDownLatch) {
        this.latch= countDownLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println("thread:" + Thread.currentThread().getName() + " is running");
            Thread.sleep(3000);
            System.out.println("thread:" + Thread.currentThread().getName() + " is finish");
            latch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class CountDownLatchClient {
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);

        new Thread(new Worker(latch)).start();
        new Thread(new Worker(latch)).start();
        try {
            System.out.println("waiting 2 threads..");
            latch.await();
            System.out.println("2 threads finish.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```
`final CountDownLatch latch = new CountDownLatch(2)` means this latch waiting for 2 threads finish. `latch.await()`
in the client will block the main thread until both workers are finished. Both `Worker` accept the instance of `CountDownLatch`, 
when workers finish they will invoke the `countDown` method. This method will decrease the count in the latch. 
When the count of latch becomes 0 the main thread will be week up.

The output is like following.
```
waiting 2 threads..
thread:Thread-1 is running
thread:Thread-0 is running
thread:Thread-1 is finish
thread:Thread-0 is finish
2 threads finish.
```

EOF