package com.henryxi.core.time.diff;

import java.time.Duration;
import java.time.Instant;

public class TimeDifferentClient {
    public static void main(String[] args) throws InterruptedException {
        Instant firstTime = Instant.ofEpochMilli(System.currentTimeMillis());
        Thread.sleep(10 * 1000);
        Instant secondTime = Instant.ofEpochMilli(System.currentTimeMillis());
        Duration timeElapsed = Duration.between(firstTime, secondTime);
        System.out.println("duration second:" + timeElapsed.getSeconds());
    }
}
