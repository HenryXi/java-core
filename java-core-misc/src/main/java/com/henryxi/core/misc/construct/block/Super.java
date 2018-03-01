package com.henryxi.core.misc.construct.block;

public class Super {
    public Super() {
        System.out.println("Super constructor");
    }

    {
        System.out.println("Super block");
    }

    static {
        System.out.println("static Super");
    }
}
