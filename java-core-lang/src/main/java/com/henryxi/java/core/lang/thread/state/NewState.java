package com.henryxi.java.core.lang.thread.state;

public class NewState implements PrintThreadState {
    public void print() {
        Thread newState = new Thread();
        System.out.println("new state:" + newState.getState());
    }
}
