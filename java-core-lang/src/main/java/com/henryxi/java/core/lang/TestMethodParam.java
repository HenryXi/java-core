package com.henryxi.java.core.lang;

public class TestMethodParam {
    public static void main(String[] args) {
        String init = "init";
        test(init);
        System.out.println(init);
    }
    public static void test(String testStr){
        System.out.println(testStr);
        testStr = "new string";
        System.out.println(testStr);
    }
}
