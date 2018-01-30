package com.henryxi.java.core.lang.thread.state;

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
