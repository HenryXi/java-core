package com.henryxi.java.core.lang.fina11y;

public class TestFinally {
    public static void main(String[] args) throws Exception {
        String test = "test";
        try {
            try {
                if (test.equals("test")) {
                    throw new Exception("test");
                }
            } finally {
                System.out.println("first finally");
            }
        } catch (Exception e) {
            System.out.println("throw exception");
        } finally {
            System.out.println("finally");
        }
    }
}
