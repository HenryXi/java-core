# Java Thread state example
There are 6 states for Java Thread. From JDK comment it says that `A thread can be in only one state at a given point in time`.
In this page I will show you different states in thread life cycle. Hope the sample code can help you understand the states
better. 

In order to show the state of threads I create an interface and a client. I write different classes to generate different states
and print them out. 
```java
public interface ThreadState {
    void printStateInfo();
}

public class ThreadStateClient {

    public static void main(String[] args) throws InterruptedException {
        ThreadState newState = new NewState();
        newState.printStateInfo();

        ThreadState runnableState = new RunnableState();
        runnableState.printStateInfo();

        ThreadState blockedState = new BlockedState();
        blockedState.printStateInfo();

        ThreadState waitingState = new WaitingState();
        waitingState.printStateInfo();

        ThreadState timedWaitingState = new TimedWaiting();
        timedWaitingState.printStateInfo();

        ThreadState terminatedState = new TerminatedState();
        terminatedState.printStateInfo();
    }
}
```
**New**

When a thread has not started, its state is `NEW`.
```java
public class NewState implements ThreadState {
    public void printStateInfo() {
        Thread newState = new Thread();
        System.out.println("new state:" + newState.getState());
    }
}
```
**RUNNABLE**

When a thread is running, its state is `RUNNABLE`. 
```java
public class RunnableState implements ThreadState {
    private static volatile boolean stillRunning = true;

    @Override
    public void printStateInfo() {
        Thread startState = new Thread() {
            @Override
            public void run() {
                int i = 0;
                do {

                } while (stillRunning);
            }
        };
        startState.start();
        System.out.println("runnable state:" + startState.getState());
        stillRunning = false;
    }
}
```
**BLOCKED**

When a thread is blocked waiting for a monitor, its state is `BLOCKED`.
```java
public class BlockedState implements ThreadState {
    private static volatile boolean still_running = true;

    @Override
    public void printStateInfo() {

        Thread blockState1 = new Thread(this::syncMethod);
        blockState1.start();
        Thread blockState2 = new Thread(this::syncMethod);
        blockState2.start();
        do {
            if (blockState1.getState().equals(Thread.State.BLOCKED)) {
                System.out.println("block state:" + Thread.State.BLOCKED);
                break;
            }
            if (blockState2.getState().equals(Thread.State.BLOCKED)) {
                System.out.println("block state:" + Thread.State.BLOCKED);
                break;
            }
        } while (true);
        still_running = false;
    }

    private synchronized void syncMethod() {
        do {

        } while (still_running);
    }
}
```
**WAITING**

When a thread is waiting for another thread, its state is `WAITING`.
```java
public class WaitingState implements ThreadState {

    private final Object monitor = new Object();

    @Override
    public void printStateInfo() {
        Thread waitingThread = new Thread(this::waitMethod);
        waitingThread.start();
        do {
            if (waitingThread.getState().equals(Thread.State.WAITING)) {
                System.out.println("waiting state:" + Thread.State.WAITING);
                notifyMethod();
                break;
            }
        } while (true);
    }

    private void waitMethod() {
        synchronized (monitor) {
            try {
                monitor.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void notifyMethod() {
        synchronized (monitor) {
            monitor.notifyAll();
        }
    }
}
```
**TIMED_WAITING**

When a thread is waiting for another thread with timeout, its state is `TIMED_WAITING`.
```java
public class TimedWaiting implements ThreadState {
    @Override
    public void printStateInfo() {
        Thread timedWaiting = new Thread(this::waitMethod);
        timedWaiting.start();
        do {
            if (timedWaiting.getState().equals(Thread.State.TIMED_WAITING)) {
                System.out.println("timedWaiting state:" + Thread.State.TIMED_WAITING);
                timedWaiting.interrupt();
                break;
            }
        } while (true);
    }

    private void waitMethod() {
        try {
            Thread.sleep(1000 * 60);
        } catch (InterruptedException e) {
            System.out.print("");
        }
    }
}
```
**TERMINATED**

When a thread has finished, its state is `TERMINATED`.
```java
public class TerminatedState implements ThreadState {
    @Override
    public void printStateInfo() {
        Thread terminated = new Thread();
        terminated.start();
        do {
            if (terminated.getState().equals(Thread.State.TERMINATED)) {
                System.out.println("terminated state:" + Thread.State.TERMINATED);
                break;
            }
        } while (true);
    }
}
```

The output of `ThreadStateClient` is like following.
```
new state:NEW
runnable state:RUNNABLE
block state:BLOCKED
waiting state:WAITING
timedWaiting state:TIMED_WAITING
terminated state:TERMINATED
```
I use loop to determine the state due to the state of thread changes quickly. 

EOF