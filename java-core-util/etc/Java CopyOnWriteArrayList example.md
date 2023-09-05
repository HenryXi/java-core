# Java CopyOnWriteArrayList example
It will throw `ConcurrentModificationException` when multiple threads modify `ArrayList`. If the elements are not too much, `CopyOnWriteArrayList` is a good choice.
`CopyOnWriteArrayList` copies elements when add new element. It is not recommend to using it when the elements are too many. (It is expensive to copy too many elements.)

**ArrayList throw ConcurrentModificationException**
```java
public class ConcurrentModificationArrayListClient {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();
        Thread subThread = new Thread(new Runnable() {
            int index = 0;

            @Override
            public void run() {
                while (true) {
                    list.add("index" + index);
                    index++;
                }
            }
        });
        subThread.start();
        Thread.sleep(1000);
        while (true) {
            System.out.println(list.toString());
        }
    }
}
``` 

**CopyOnWriteArray**  
```java
public class CopyOnWriteArrayListClient {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new CopyOnWriteArrayList<>();
        Thread subThread = new Thread(new Runnable() {
            int index = 0;

            @Override
            public void run() {
                while (true) {
                    list.add("index" + index);
                    index++;
                }
            }
        });
        subThread.start();
        Thread.sleep(1000);
        while (true) {
            System.out.println(list.toString());
        }
    }
}
```

EOF