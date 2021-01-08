package com.henryxi.java.core.lang.volatile_;

public class ThreadThreadPrintClient {
    public static void main(String[] args) {
        PrintFlag flag = new PrintFlag();
        Worker abcWorker = new Worker("abc",flag,0);
        Worker defWorker = new Worker("def",flag,1);
        Worker ghiWorker = new Worker("ghi",flag,2);
        abcWorker.start();
        defWorker.start();
        ghiWorker.start();
    }
}
