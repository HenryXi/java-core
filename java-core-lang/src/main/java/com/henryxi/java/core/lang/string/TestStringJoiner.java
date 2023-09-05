package com.henryxi.java.core.lang.string;

import java.util.StringJoiner;

public class TestStringJoiner {
    public static void main(String[] args) {
        String[] stringArray = "this is a sentence".split(" ");
        StringBuilder sb = new StringBuilder();
        for (String string : stringArray) {
            sb.append(string).append(",");
        }
        System.out.println("result:" + sb.toString().substring(0, sb.toString().length() - 1));

        StringJoiner stringJoiner = new StringJoiner(",");
        for (String string : stringArray) {
            stringJoiner.add(string);
        }
        System.out.println("result:" + stringJoiner);
    }
}
