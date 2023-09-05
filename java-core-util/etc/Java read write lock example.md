# Java read write lock example
`ReadWriteLock` is used in the scenario that reading operation is more frequent than writing. It is more efficient than
`synchronized` method. Multiple read threads do not block each other, only write thread blocks read thread. The sample code
is here.
```java
public class ReadWriteLockClient {
    public static void main(String[] args) {
        Cache cache = new Cache();
        for (int i = 0; i < 2; i++) {
            new ReadThread(cache).start();
        }
        new WriteThread(cache).start();
    }
}

public class Cache {
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock readLock = readWriteLock.readLock();
    private final Lock writeLock = readWriteLock.writeLock();
    private Random random = new Random();
    private int cacheValue;

    public Cache() {
        cacheValue = random.nextInt(100);
    }

    public void read() {
        try {
            readLock.lock();
            System.out.println("read thread unblocked,the value:" + cacheValue);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }

    public void update() {
        try {
            writeLock.lock();
            System.out.println("block all read thread for setting data to new value");
            Thread.sleep(2000);
            cacheValue = random.nextInt(100);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }
}

public class ReadThread extends Thread{
    private Cache cache;

    public ReadThread(Cache cache) {
        this.cache = cache;
    }

    @Override
    public void run() {
        do{
            cache.read();
        }while (true);
    }
}

public class WriteThread extends Thread {
    private Cache cache;

    public WriteThread(Cache cache) {
        this.cache = cache;
    }

    @Override
    public void run() {
        try {
            do {
                cache.update();
                Thread.sleep(1000 * 5);
            } while (true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```
Multiple read threads can read data without blocking.
```
...
read thread unblocked,the value:36
read thread unblocked,the value:36
read thread unblocked,the value:36
read thread unblocked,the value:36
read thread unblocked,the value:36
read thread unblocked,the value:36
read thread unblocked,the value:36
block all read thread for setting data to new value
read thread unblocked,the value:64
read thread unblocked,the value:64
read thread unblocked,the value:64
read thread unblocked,the value:64
...
```

EOF