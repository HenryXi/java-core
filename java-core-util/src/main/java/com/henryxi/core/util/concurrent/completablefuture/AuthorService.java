package com.henryxi.core.util.concurrent.completablefuture;

public class AuthorService {
    public Author getAuthor(int authorId) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Author author = new Author();
        author.setAuthorId(authorId);
        author.setAuthorName("Name_" + authorId);
        return author;
    }
}
