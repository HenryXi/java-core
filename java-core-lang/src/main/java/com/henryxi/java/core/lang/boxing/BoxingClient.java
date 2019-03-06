package com.henryxi.java.core.lang.boxing;

public class BoxingClient {
    public static void main(String[] args) {
        Long value = getLong();
        System.out.println(value);
    }

    private static long getLong() {
        return getInt();
    }

    private static int getInt() {
        return 1;
    }
}
