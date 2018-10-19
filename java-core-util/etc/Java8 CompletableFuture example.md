# Java8 CompletableFuture example
We can use `stream().parallel()` to handle tasks in multi-thread. `CompletableFuture` is very useful when you handle tasks
which need to wait IO or network. Let's say you have two services. The one is getting content by contentId and another is
getting author information by authorId. Both of them need RPC. In other words, you have to wait the remote server responses.
I use `Thread.sleep()` to mock network delays.
```java
public class Content {
    private String content;
    private int authorId;

    //getter and setter
}

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

public class Author {
    private int authorId;
    private String authorName;

    //getter and setter
}

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
``` 
I use different ways to get contents and authors information. 
```java
public class CompletableFutureClient {

    private static ContentService contentService = new ContentService();
    private static AuthorService authorService = new AuthorService();

    public static void main(String[] args) {
        List<Integer> contentsId = Arrays.asList(6, 8, 9, 66, 18, 99, 68, 89, 100, 166);
        normalStream(contentsId);
        parallelStream(contentsId);
        completableFutureStream(contentsId);
        completableFutureStreamWithExecutors(contentsId);
    }

    private static void normalStream(List<Integer> contentsId) {
        long beginTime = System.currentTimeMillis();
        List<Author> authorList = contentsId.stream()
                .map(i -> contentService.getContent(i))
                .map(a -> authorService.getAuthor(a.getAuthorId()))
                .collect(toList());
        long endTime = System.currentTimeMillis();
        System.out.println("normalStream cost:" + (endTime - beginTime) + ", authors:" + authorList);
    }

    private static void parallelStream(List<Integer> contentsId) {
        long beginTime = System.currentTimeMillis();
        List<Author> authorList = contentsId.stream().parallel()
                .map(i -> contentService.getContent(i))
                .map(a -> authorService.getAuthor(a.getAuthorId()))
                .collect(toList());
        long endTime = System.currentTimeMillis();
        System.out.println("parallelStream cost:" + (endTime - beginTime) + ", authors:" + authorList);
    }

    private static void completableFutureStream(List<Integer> contentsId) {
        long beginTime = System.currentTimeMillis();
        List<CompletableFuture<Author>> authorsFutures = contentsId.stream()
                .map(i -> CompletableFuture.supplyAsync(() -> contentService.getContent(i)))
                .map(future -> future.thenCompose(content -> CompletableFuture.supplyAsync(() -> authorService.getAuthor(content.getAuthorId()))))
                .collect(toList());
        List<Author> authorList = authorsFutures.stream().map(CompletableFuture::join).collect(toList());
        long endTime = System.currentTimeMillis();
        System.out.println("completableFutureStream cost:" + (endTime - beginTime) + ", authors:" + authorList);
    }

    private static void completableFutureStreamWithExecutors(List<Integer> contentsId) {
        final Executor executor =
                Executors.newFixedThreadPool(Math.min(contentsId.size(), 100), r -> {
                    Thread t = new Thread(r);
                    t.setDaemon(true);
                    return t;
                });
        long beginTime = System.currentTimeMillis();
        List<CompletableFuture<Author>> authorsFutures = contentsId.stream()
                .map(i -> CompletableFuture.supplyAsync(() -> contentService.getContent(i), executor))
                .map(future -> future.thenCompose(content -> CompletableFuture.supplyAsync(() -> authorService.getAuthor(content.getAuthorId()), executor)))
                .collect(toList());
        List<Author> authorList = authorsFutures.stream().map(CompletableFuture::join).collect(toList());
        long endTime = System.currentTimeMillis();
        System.out.println("completableFutureStreamWithExecutors cost:" + (endTime - beginTime) + ", authors:" + authorList);
    }
}
```
The output is here.
```
normalStream cost:20043, authors size:10
parallelStream cost:4012, authors size:10
completableFutureStream cost:4010, authors size:10
completableFutureStreamWithExecutors cost:2010, authors size:10
```

* normal stream: handle contents and authors in one thread.
* parallel stream: use multi-thread to handle task. The number of thread is depend on number of CPU cores.
* CompletableFuture: getting contents and authors asynchronously in multi-threaded way. The number of thread is depend on number of CPU cores.
* CompletableFuture with executors: getting contents and authors asynchronously in multi-threaded way. You specify the number of threads.

EOF