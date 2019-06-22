package com.henryxi.java.core.lang.exception;

public class ExceptionStackTraceClient {
    public static void main(String[] args) {
        ExceptionStackTraceClient client = new ExceptionStackTraceClient();
        client.throwException();
    }

    private void throwException() {
        for (int i = 0; i < 1_000_000_000; i++) {
            try {
                ((Object) null).getClass();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
