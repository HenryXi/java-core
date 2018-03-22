# Java create deadlock example
Deadlock means multiple workers(threads) are waiting for each other release common resource. In this blog I will create 
a deadlock example. Two workers both need lock1 and lock2 to finish the task. When one hold lock1 and another hold lock2
they are both waiting for another to release the lock. This state is called dead lock.
```java
public class Worker1 extends Thread {
    private final Object lock1;
    private final Object lock2;

    public Worker1(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        while (true){
            synchronized (lock1) {
                System.out.println(currentThread().getName()+" get lock1");
                synchronized (lock2) {
                    System.out.println(currentThread().getName()+" get lock2");
                }
                System.out.println(currentThread().getName()+" release lock2");
            }
            System.out.println(currentThread().getName()+" release lock1");
        }
    }
}

public class Worker2 extends Thread {
    private final Object lock1;
    private final Object lock2;

    public Worker2(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        while (true){
            synchronized (lock2) {
                System.out.println(currentThread().getName()+" get lock2");
                synchronized (lock1) {
                    System.out.println(currentThread().getName()+" get lock1");
                }
                System.out.println(currentThread().getName()+" release lock1");
            }
            System.out.println(currentThread().getName()+" release lock2");
        }
    }
}

public class DeadlockClient {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();
        Worker1 worker1 = new Worker1(lock1, lock2);
        Worker2 worker2 = new Worker2(lock1, lock2);
        worker1.start();
        worker2.start();
    }
}
```
The output is like following.
```
Thread-1 get lock2
Thread-0 get lock1
``` 

EOF