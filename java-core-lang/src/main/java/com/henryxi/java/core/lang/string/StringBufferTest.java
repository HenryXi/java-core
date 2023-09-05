package com.henryxi.java.core.lang.string;

public class StringBufferTest {
    public static void main(String[] args) {
        StringBuilder a = new StringBuilder("a");
        StringBuilder b = new StringBuilder("b");
        show(a, b);
        System.out.println(a + " ****** " + b);
    }

    private static void show(final StringBuilder a, StringBuilder b) {
        a.append(b);
        System.out.println(a + " ****** " + b);
        b = a;
        System.out.println(a + " ****** " + b);
        b.append(a);
        System.out.println(a + " ****** " + b);
    }
}
