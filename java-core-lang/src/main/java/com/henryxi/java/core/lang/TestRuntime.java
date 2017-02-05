package com.henryxi.java.core.lang;

import java.io.IOException;

public class TestRuntime {
    public static void main(String[] args) throws IOException {
        Runtime rt = Runtime.getRuntime();
        Process pr = rt.exec("java");
    }

}
