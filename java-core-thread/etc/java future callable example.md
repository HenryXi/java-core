# Java future callable example
In this blog I will show you how to use `Future` and `Callable` to get the result asynchronously. Write your logic
code in `call` method of `Callable` then submit it and get `Future`. `isDone` method in `Future` class can help you to 
get the result of your task. `get` method of `Future` class will get the result of your task, this method will block the thread
if the task doesn't finish. Sample code is like following.

**Task class**
```java
class Task implements Callable<String> {
    public String call() throws Exception {
        System.out.println("this is task class , I am running");
        Thread.sleep(2000);
        System.out.println("this is task class , I am stopping");
        return "task result";
    }
}
```

**Client**
```java
public class FutureClient {
    public static void main(String[] args) throws Exception {
        Task task = new Task();
        ExecutorService es = Executors.newCachedThreadPool();
        Future future = es.submit(task);
        System.out.println("this is main thread, after submitting callable class. state of task:" + future.isDone());
        Thread.sleep(3000);
        System.out.println("this is main thread, after 3 seconds. state of task:" + future.isDone());
        Thread.sleep(2000);
        System.out.println("the result of task class:" + future.get());
        es.shutdownNow();
    }
}
```

The output is like following.
```
this is main thread, after submitting callable class. state of task:false
this is task class , I am running
this is task class , I am stopping
this is main thread, after 3 seconds. state of task:true
the result of task class:task result
```
