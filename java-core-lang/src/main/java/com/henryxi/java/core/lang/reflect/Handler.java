package com.henryxi.java.core.lang.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Handler implements InvocationHandler {
    private Interface sub;

    public Handler() {
    }

    public Handler(Interface obj) {
        sub = obj;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before calling real method:" + method.getName());
        method.invoke(sub, args);
        System.out.println("after calling real method:" + method.getName());
        return null;
    }
}
