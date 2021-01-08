package com.henryxi.java.core.lang.volatile_;

public class Worker extends Thread {
    private String value;
    private PrintFlag printFlag;
    private int index;

    public Worker(String value, PrintFlag flag, int index) {
        this.value = value;
        this.printFlag = flag;
        this.index = index;
    }

    public void run() {
        int i = 0;
        do {
            if (i > value.length() - 1) {
                break;
            }
            if (printFlag.getIndex() % 3 == index) {
                System.out.println(value.charAt(i++));
                printFlag.addIndex();
            }
        } while (true);
    }
}
