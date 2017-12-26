package com.henryxi.core.misc.construct;

public class Child extends Super {
    public Child() {
        System.out.println("Child constructor");
    }

    {
        System.out.println("Child block");
    }

    static {
        System.out.println("static Child");
    }
}
