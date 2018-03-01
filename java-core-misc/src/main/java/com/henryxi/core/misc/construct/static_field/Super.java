package com.henryxi.core.misc.construct.static_field;

public class Super {
    public Super() {
        System.out.println("Super constructor");
    }

    {
        System.out.println("Super block");
    }

    static {
        System.out.println("Super static");
    }
}
