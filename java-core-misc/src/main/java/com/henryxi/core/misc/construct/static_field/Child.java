package com.henryxi.core.misc.construct.static_field;

public class Child extends Super {

    {
        System.out.println("Child block");
    }

    static {
        System.out.println("Child static");
    }

    private static class InnerStaticClass {
        private static Child instance = new Child();
    }

    private Child() {
        System.out.println("Child constructor");
    }

    public static Child getInstance() {
        System.out.println("Child static method:getInstance");
        return InnerStaticClass.instance;
    }
}
