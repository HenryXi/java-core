package com.henryxi.java.core.lang.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {
    static public void main(String[] args) throws Throwable {
        TargetClass rs = new TargetClass();
        InvocationHandler ds = new ProxyImpl(rs);
        Class cls = rs.getClass();
        Interface anInterface = (Interface) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), ds);
        anInterface.request();
    }
}
