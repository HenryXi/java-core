package com.henryxi.java.core.lang.thread.state;

public class ThreadStateClient {


    public static void main(String[] args) throws InterruptedException {
        PrintThreadState newState = new NewState();
        newState.print();

        PrintThreadState runnableState = new RunnableState();
        runnableState.print();

        PrintThreadState blockedState = new BlockedState();
        blockedState.print();

        PrintThreadState waitingState = new WaitingState();
        waitingState.print();

        PrintThreadState timedWaitingState = new TimedWaiting();
        timedWaitingState.print();

        PrintThreadState terminatedState = new TerminatedState();
        terminatedState.print();
    }
}
