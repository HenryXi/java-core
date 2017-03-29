package com.henryxi.java.core.lang;

import java.util.StringJoiner;

public class StringLength {
    public static void main(String[] args) {
        String test = "Java bloc kin gqueue pro ducer con sumer exam ple asdf";

        String[] array = test.split(" ");

        StringJoiner sj = new StringJoiner(" ");
        for (String word : array) {
            if (sj.length() < 36) {
                sj.add(word);
            } else {
                break;
            }
        }
        System.out.println(sj);
    }
}
