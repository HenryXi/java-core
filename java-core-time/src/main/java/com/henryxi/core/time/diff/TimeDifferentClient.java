package com.henryxi.core.time.diff;

import java.time.Duration;
import java.time.Instant;

public class TimeDifferentClient {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Integer.MAX_VALUE);
        Instant firstTime = Instant.ofEpochMilli(System.currentTimeMillis());
        Thread.sleep(10 * 1000);
        Instant secondTime = Instant.ofEpochMilli(System.currentTimeMillis());
        Duration timeElapsed = Duration.between(secondTime, firstTime);
        System.out.println("duration second:" + timeElapsed.getSeconds());
    }
}
