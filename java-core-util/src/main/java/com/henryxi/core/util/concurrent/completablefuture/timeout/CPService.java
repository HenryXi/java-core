package com.henryxi.core.util.concurrent.completablefuture.timeout;

import java.util.Random;

public class CPService {
    private Random random = new Random();

    public CPFeed getCPFeed(int contentId) {
        try {
            int timeout = random.nextInt(1000);
            System.out.println("contentId:" + contentId + ",timeout:" + timeout);
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        CPFeed CPFeed = new CPFeed();
        CPFeed.setAuthorId(contentId);
        CPFeed.setContent("This is CPFeed of " + contentId);
        return CPFeed;
    }
}
