package com.henryxi.thread;

public class multiThreadAlternateExecute2 {

    private static volatile boolean flag;

    public static void main(String[] args) {
        Thread a = new Thread() {
            public void run() {
                while (true) {
                    if (flag) {
                        for (int i = 0; i < 3; i++) {
                            System.out.println("a execute");
                        }
                        flag = false;
                    }
                }
            }
        };
        Thread b = new Thread() {
            public void run() {
                while (true) {
                    if (!flag) {
                        for (int i = 0; i < 3; i++) {
                            System.out.println("b execute");
                        }
                        flag = true;
                    }
                }
            }
        };
        a.start();
        b.start();
    }
}
