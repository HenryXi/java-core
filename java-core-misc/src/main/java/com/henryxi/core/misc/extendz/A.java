package com.henryxi.core.misc.extendz;

public class A extends B {
    public static void main(String[] args) {
        A a = new A();
        a.method3();
    }

    public void method3() {
        System.out.println("this is A's public method");
        method1();
    }
}
