# Java ReentrantLock example
`ReentrantLock` and `synchronized` keyword both can make sure only one thread execute the code on the same time. They are similar
but not the same. `ReentrantLock` is more flexible than `synchronized`. In this page I will show you a simple 
use case of `ReentrantLock`.

**Worker.java**
```java
public class Worker {
    private static Lock lock = new ReentrantLock();

    private static int count = 0;

    public void execute(long time) {
        Thread thread = Thread.currentThread();
        lock.lock(); // current thread get the lock
        System.out.println("this is: " + thread.getName() + " current count:" + count++);
        lock.unlock();// current thread release the lock
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```

**Client.java**
```java
public class Client {
    public static void main(String[] args) {
        Worker worker = new Worker();
        new Thread(){
            @Override
            public void run() {
                while (true){
                    worker.execute(3000);
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                while (true){
                    worker.execute(3000);
                }
            }
        }.start();
    }
}
```

We start two threads to print out the thread name and the number of count. `ReentrantLock` makes sure only one thread 
is printing on the same time. One thread will be blocked until getting the lock. 