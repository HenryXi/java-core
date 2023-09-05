package com.henryxi.java.core.lang.fina11y;

public class TestFinallySystemExit {
    public static void main(String[] args) {
        try{
            System.out.println("begin");
            System.exit(0);
        }finally {
            System.out.println("this is finally");
        }
    }
}
