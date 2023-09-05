package com.henryxi.java.core.lang.thread.state;

public class NewState implements ThreadState {
    public void printStateInfo() {
        Thread newState = new Thread();
        System.out.println("new state:" + newState.getState());
    }
}
