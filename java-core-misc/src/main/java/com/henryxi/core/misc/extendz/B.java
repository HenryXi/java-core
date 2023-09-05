package com.henryxi.core.misc.extendz;

public class B {
    public void method1() {
        System.out.println("this is B's public method");
        method2();
    }

    private void method2() {
        System.out.println("this is B's private method");
    }

    public void anotherMethod1() {
        System.out.println("this is B's public method");
        System.out.println("this is B's private method");
    }
}
