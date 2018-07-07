# Java8 Collectors.partitioningBy example
`Collectors.partitioningBy` is used to divide stream into two map. The key of two group are true and false. Two list of
values are collections of elements that satisfy the condition. The example code is here.
```java
public class CollectorsPartitioningByClient {
    public static void main(String[] args) {
        Map<Boolean, List<Integer>> evenMap = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println(evenMap);

        List<User> users = new ArrayList<>();
        users.add(new User("Henry", 30));
        users.add(new User("Justin", 27));
        users.add(new User("Mathew", 26));
        Map<Boolean, List<User>> biggerThan30Map = users.stream().collect(Collectors.partitioningBy(u -> u.getAge() >= 30));
        System.out.println(biggerThan30Map);
    }
}
```
output
```
{false=[1, 3, 5, 7, 9], true=[2, 4, 6, 8, 10]}
{false=[User{name='Justin', age=27}, User{name='Mathew', age=26}], true=[User{name='Henry', age=30}]}
```

EOF