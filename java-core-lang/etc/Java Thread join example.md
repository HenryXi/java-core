# Java Thread join example
`join()` method of `Thread` class will wait the sub thread to finish then to continue the current thread. "join" looks 
like the sub-thread join the main thread. If you want to know the result of sub-thread, `join` can help you blocked the 
main thread until sub-thread finish(dead).

```
Main thread-->----->----->----->--block##########continue--->---->
                 \                 |               |
sub thread start()\                | join()        |
                   \               |               |
                    ---sub thread----->--->--->--finish    
``` 

**code*
```java
public class SubThreadNeed4Seconds extends Thread {
    public SubThreadNeed4Seconds(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " sub thread start");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " sub thread end");
    }
}

public class ThreadJoinClient {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main thread start");
        Thread t1 = new SubThreadNeed4Seconds("t1");
        t1.start();
        System.out.println("main thread wait t1 finish");
        t1.join();
        System.out.println("main thread after t1.join()");
        Thread t2 = new SubThreadNeed4Seconds("t2");
        t2.start();
        System.out.println("main thread wait t2 1 second, if t2 not finish continue");
        t2.join(1000);
        System.out.println("main thread after t2.join(1000)");
    }
}
```
**output**
```
main thread start
main thread wait t1 finish
t1 sub thread start
t1 sub thread end
main thread after t1.join()
main thread wait t2 1 second, if t2 not finish continue
t2 sub thread start
main thread after t2.join(1000)
t2 sub thread end
```
**summary**

* `join()` method will block the current thread until sub-thread finish.
* `join(long millis)` method will block the current thread for millis, if sub-thread not finish then continue the current thread.

EOF