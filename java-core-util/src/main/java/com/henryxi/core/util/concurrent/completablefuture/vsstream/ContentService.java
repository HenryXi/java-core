package com.henryxi.core.util.concurrent.completablefuture.vsstream;

public class ContentService {
    public Content getContent(int contentId) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Content content = new Content();
        content.setAuthorId(contentId);
        content.setContent("This is content of " + contentId);
        return content;
    }
}
