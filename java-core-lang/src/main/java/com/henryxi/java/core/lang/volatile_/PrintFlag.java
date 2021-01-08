package com.henryxi.java.core.lang.volatile_;

public class PrintFlag {
    private volatile int index = 0 ;

    public int getIndex(){
        return index;
    }

    public void addIndex(){
        index++;
    }
}
