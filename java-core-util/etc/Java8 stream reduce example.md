# Java8 stream reduce example
`reduce` method of stream is used to calculate elements in the stream and get the result. For example, we can use `reduce`
to get the sum of `Integer` list. It can also help you to get the min or max number of `Integer` list.
```java
public class StreamReduceClient {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(6, 5, 8, 9, 63, 36, 83, 85, 86, 96);
        Integer sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println("sum:" + sum);

        Integer max = numbers.stream().reduce(-1, Integer::max);
        System.out.println("max:" + max);

        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        System.out.println("min:" + min.orElse(-1));
    }
}
```
There are two different `reduce` methods `T reduce(T identity, BinaryOperator<T> accumulator)` and `Optional<T> reduce(BinaryOperator<T> accumulator)`.
The first method will return "identity" if `Integer` list is empty collection. The second method will produce `Optional` 
Object. It means the value maybe is null.

The output of above code.
```
sum:477
max:96
min:5
```

EOF