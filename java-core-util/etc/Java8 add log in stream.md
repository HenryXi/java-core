# Java8 add log in stream
`Stream` in Java8 can help us make code clear and efficient. We can use `Stream` to iterate a collection without the
keyword `for`. It is very convenient. The question is how to print the information of item in a stream?
In this page I will show you how to add log in stream. JDK provides `peek` function for debugging.
```java
public class StreamPeekClient {
    public static void main(String[] args) {
        List<Integer> integerList = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
        int sum = integerList.stream()
                .peek(i -> System.out.println("origin:" + i))
                .mapToInt(i -> i + 1)
                .peek(i -> System.out.println("processed:" + i)).sum();
        System.out.println("sum:" + sum);
    }
}
```
The output is like following.
```
origin:1
processed:2
origin:2
processed:3
origin:3
processed:4
origin:4
processed:5
origin:5
processed:6
origin:6
processed:7
origin:7
processed:8
origin:8
processed:9
origin:9
processed:10
origin:10
processed:11
sum:65
```
`peek` method receives a stream and produce another. That gives us a chance to print the information 
of items and do not effect current stream.

EOF