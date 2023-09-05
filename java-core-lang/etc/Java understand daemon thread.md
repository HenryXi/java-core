# Java understand daemon thread
Recently I am writing a program that processes messages in the background. The program quits when I start 10 threads.
I checked all the exception stack information and found no errors. I tried to find this "error" on Google and didn't find any useful information.
Why my program or my thread stop? I read my code line by line. It seems like following.
```java
public class DaemonClient {
    public static void main(String[] args) {
        List<Thread> threadList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new MyThread());
            thread.setDaemon(true);
            threadList.add(thread);
        }
        threadList.forEach(Thread::start);
        System.out.println("main finish");
    }
}
```
What does `daemon` mean? I ask myself. I find that I don’t understand very well what this method does. I read the jdk documentation 
for this method.

> Marks this thread as either a daemon thread or a user thread. **The Java Virtual Machine exits when the only threads running are 
 all daemon threads.** This method must be invoked before the thread is started.
 
Wait! What does this mean for "The Java Virtual Machine exits when the only threads running are all daemon threads."?
If my program only has daemon threads JVM will exits? 

Now I know why my program quits. I only start 10 daemon threads. When the main thread(not daemon thread) finished only 
daemon threads are running then JVM exits.

I remove `thread.setDeamon(true)` and rerun this program everything is OK. 

EOF