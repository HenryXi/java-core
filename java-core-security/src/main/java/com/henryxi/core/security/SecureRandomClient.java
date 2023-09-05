package com.henryxi.core.security;

import java.security.SecureRandom;

public class SecureRandomClient {
    private static final String symbols = "ABCDEFGJKLMNPRSTUVWXYZ0123456789";
    public static void main(String[] args) {

        SecureRandom rand = new SecureRandom();
        int rand_int1 = rand.nextInt(1000);
        System.out.println("Random Integers: " + rand_int1);
    }
}
