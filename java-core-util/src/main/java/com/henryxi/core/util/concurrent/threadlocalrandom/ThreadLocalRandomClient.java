package com.henryxi.core.util.concurrent.threadlocalrandom;

import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalRandomClient {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int randomInt = ThreadLocalRandom.current().nextInt();
            int randomIntLessThan2 = ThreadLocalRandom.current().nextInt(2);
            int randomIntBiggerOrEqualThen2LessThan5 = ThreadLocalRandom.current().nextInt(2, 5);
            System.out.println("randomInt:" + randomInt);
            System.out.println("randomIntLessThan2:" + randomIntLessThan2);
            System.out.println("randomIntBiggerOrEqualThen2LessThan5:" + randomIntBiggerOrEqualThen2LessThan5);
        }
    }
}
