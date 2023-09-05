package com.henryxi.core.util.concurrent.completablefuture.timeout;

public class CPFeed {
    private String content;
    private int authorId;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "CPFeed{" +
                "content='" + content + '\'' +
                ", authorId=" + authorId +
                '}';
    }
}
