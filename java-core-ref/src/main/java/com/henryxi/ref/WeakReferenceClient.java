package com.henryxi.ref;

import java.lang.ref.WeakReference;

public class WeakReferenceClient {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("hello, world");
        WeakReference<StringBuffer> ref = new WeakReference<>(str);
//        System.out.println("before set to null:" + ref.get());
        str = null;
//        System.out.println("after set to null:" + ref.get());
        if (ref != null) {
            System.gc();
            System.out.println("after gc:" + ref.get());
        }
    }
}
