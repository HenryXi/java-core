package com.henryxi.java.core.lang.system;

public class ModifyLibraryPath {
    public static void main(String[] args) {
        System.loadLibrary("\\");
        System.out.println(System.getenv("java.library.path"));
    }
}
