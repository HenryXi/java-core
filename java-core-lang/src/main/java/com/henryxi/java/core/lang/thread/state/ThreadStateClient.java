package com.henryxi.java.core.lang.thread.state;

public class ThreadStateClient {


    public static void main(String[] args) throws InterruptedException {
        ThreadState newState = new NewState();
        newState.print();

        ThreadState runnableState = new RunnableState();
        runnableState.print();

        ThreadState blockedState = new BlockedState();
        blockedState.print();

        ThreadState waitingState = new WaitingState();
        waitingState.print();

        ThreadState timedWaitingState = new TimedWaiting();
        timedWaitingState.print();

        ThreadState terminatedState = new TerminatedState();
        terminatedState.print();
    }
}
