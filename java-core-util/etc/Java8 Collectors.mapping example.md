# Java8 Collectors.mapping example
There are many practical methods in the `Collectors` class. `mapping` method is one of them. In this page I will show you
how to use `mapping` method in `Collectors`. Let's say you have a list of users(List<User>). Let's say you want to group 
these users by age. The code will be like this.

```java
Map<Integer, List<User>> userMap = users.stream().collect(Collectors.groupingBy(User::getAge));
```

If you want to get a collection of names that users group by age, then you need to use the `mapping` method. We can map
`User` to user's name and collect them.

```java
Map<Integer, List<String>> userAgeNameMap = users.stream().collect(Collectors.groupingBy(User::getAge, Collectors.mapping(User::getName, Collectors.toList())));
```

The complete code and output are as follows.
```java
public class CollectorsMappingClient {
    public static void main(String[] args) {
        User user1 = new User("henry", 30);
        User user2 = new User("justin", 29);
        User user3 = new User("mathew", 25);
        User user4 = new User("charles", 30);
        List<User> users = Arrays.asList(user1, user2, user3, user4);
        Map<Integer, List<User>> userMap = users.stream().collect(Collectors.groupingBy(User::getAge));
        System.out.println(userMap);

        Map<Integer, List<String>> userAgeNameMap = users.stream().collect(Collectors.groupingBy(User::getAge, Collectors.mapping(User::getName, Collectors.toList())));
        System.out.println(userAgeNameMap);
    }
}

public class User {
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private String name;
    private int age;
    
    //getter and setter

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
```
output.
```
{25=[User{name='mathew', age=25}], 29=[User{name='justin', age=29}], 30=[User{name='henry', age=30}, User{name='charles', age=30}]}
{25=[mathew], 29=[justin], 30=[henry, charles]}
```