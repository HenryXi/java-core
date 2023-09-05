package com.henryxi.java.core.lang.fina11y;

public class TestFinallyReturn {
    public static void main(String[] args) throws Exception {
        try {
            System.out.println("begin");
            int i = 10 + 1;
            if (i > 10) {
                return;
            }
            System.out.println("not here");
        } finally {
            System.out.println("finally");
        }
    }
}
