# Java8 calculate time difference milliseconds
In this blog I will show you how to calculate two milliseconds in Java8. Java8 adds a new package `java.time`. It is easy
to handle time by using the class in this package. The example code is here.
```java
public class TimeDifferentClient {
    public static void main(String[] args) throws InterruptedException {
        Instant firstTime = Instant.ofEpochMilli(System.currentTimeMillis());
        Thread.sleep(10 * 1000);
        Instant secondTime = Instant.ofEpochMilli(System.currentTimeMillis());
        Duration timeElapsed = Duration.between(firstTime, secondTime);
        System.out.println("duration second:" + timeElapsed.getSeconds());
    }
}
```
The example code needs 10 seconds to run. The output will be "duration second:10".

EOF