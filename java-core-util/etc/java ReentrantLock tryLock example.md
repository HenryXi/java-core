# Java ReentrantLock tryLock example
`RentrantLock` is more flexible than `synchronized`. When using `synchronized`, the thread will be blocked if the lock cannot be obtained.
If `RentrantLock` is used, the above problem will not occur. We can use the `tryLock` method to try to obtain the lock and
 process our own business logic by obtaining the result. 
 
Here is a specific example
```
public class TryLockClient {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        new Thread(() -> {
            lock.lock();
            try {
                for (int i = 0; i < 2; i++) {
                    System.out.println(i);
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            boolean isGetLock = false;
            try {
                isGetLock = lock.tryLock(3, TimeUnit.SECONDS);
                System.out.println("isGetLock:" + isGetLock);
                if (isGetLock) {
                    for (int i = 0; i < 10; i++) {
                        System.out.println("t2:" + i);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (isGetLock) {
                    System.out.println("unlock");
                    lock.unlock();
                }
            }
        }).start();
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("main running...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
```
There are two threads here. Thread 1 acquires the lock after starting and then starts to output numbers. Thread 2 tries 
to acquire the lock within three seconds. If it succeeds, it starts to output numbers and finally releases the lock. 
Do nothing if it fails to acquire the lock.

EOF