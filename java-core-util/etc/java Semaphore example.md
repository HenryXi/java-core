# Java Semaphore example
`Semaphore` is used to control the number of available threads. Let's say you have a lot of workers and only 5
computers. When workers finish his work he has to release the computer for next worker. `Semaphore` is good at
handle this case. The example of `Semaphore` is here.
```java
public class Worker implements Runnable {
    private int num;
    private Semaphore semaphore;

    public Worker(int num, Semaphore semaphore) {
        this.num = num;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println("thread" + this.num + " acquire a computer...");
            Thread.sleep(2000);
            System.out.println("thread" + this.num + " release the computer.");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class SemaphoreClient {
    public static void main(String[] args) {
        int N = 8;
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < N; i++) {
            new Thread(new Worker(i, semaphore)).start();
        }
    }
}
```
output
```
thread0 acquire a computer...
thread2 acquire a computer...
thread1 acquire a computer...
thread4 acquire a computer...
thread3 acquire a computer...
thread1 release the computer
thread2 release the computer
thread4 release the computer
thread3 release the computer
thread0 release the computer
thread7 acquire a computer...
thread6 acquire a computer...
thread5 acquire a computer...
thread7 release the computer
thread6 release the computer
thread5 release the computer
```