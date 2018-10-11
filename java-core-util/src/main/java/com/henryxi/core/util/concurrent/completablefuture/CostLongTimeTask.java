package com.henryxi.core.util.concurrent.completablefuture;

import java.util.Random;

public class CostLongTimeTask {
    public int costLongTimeDoSomething() {
        Random random = new Random();
        try {
            Thread.sleep(random.nextInt(5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return random.nextInt();
    }
}
