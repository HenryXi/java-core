package com.henryxi.java.core.lang.clazz;

public class TestIsAssignedFrom {
    public static void main(String[] args) {
        System.out.println(TestInterface.class.isAssignableFrom(TestImpClazz.class));
        System.out.println(TestImpClazz.class.isAssignableFrom(TestSubClazz.class));
        System.out.println(TestImpClazz.class.isAssignableFrom(TestImpClazz.class));

        System.out.println(TestImpClazz.class.isAssignableFrom(TestInterface.class));
        System.out.println(TestSubClazz.class.isAssignableFrom(TestImpClazz.class));
    }
}
