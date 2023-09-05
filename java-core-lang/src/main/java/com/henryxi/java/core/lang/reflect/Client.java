package com.henryxi.java.core.lang.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {
    static public void main(String[] args) throws Throwable {
        TargetClass rs = new TargetClass();
        InvocationHandler handler = new Handler(rs);
        Class cls = rs.getClass();
        Interface proxy = (Interface) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), handler);
        proxy.request();
    }
}
