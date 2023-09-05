# Java8 stream map example
`map` function in `Stream` class means you can pass `Function` and get another `Stream` result. It is very useful when you
want convert collection to another collection. In this page I'll give you a demonstration how to convert list
of `User` to a list of user's name and age.
```java
public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
    // getter and setter methods
}

public class StreamMapClient {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("henry", 28));
        users.add(new User("justin", 27));
        users.add(new User("Mathew", 26));
        List<Integer> ages = users.stream().map(User::getAge).collect(Collectors.toList());
        List<String> names = users.stream().map(User::getName).collect(Collectors.toList());
        System.out.println(ages);
        System.out.println(names);
    }
}
```
output
```
[28, 27, 26]
[henry, justin, Mathew]
```

EOF