# Java comparable and comparator example
There are two ways to sort multiple objects. Create a `Comparator` or make objects implement `Comparable` interface.
In this blog I will show you how to sort multiple objects.

**1. Create a `Comparator`**

User
```java
public class User {
    private int age;
    private String username;

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", username='" + username + '\'' +
                '}';
    }

    //getter and setter methods
}
```
Comparator
```java
public class ComparatorByAge implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        int age1 = o1.getAge();
        int age2 = o2.getAge();
        return (age1 < age2) ? -1 : ((age1 == age2) ? 0 : 1);
    }
}
```
Use comparator to sort objects.
```java
List<User> userList = new LinkedList<>();
userList.add(new User("Henry", 27));
userList.add(new User("Justin", 26));
userList.add(new User("Charles", 32));
System.out.println("before sorted:" + userList);
Collections.sort(userList, new ComparatorByAge());
System.out.println("after sorted:" + userList);
```
The output is like following.
```
before sorted:[ComparableUser{username='Henry', age=27}, ComparableUser{username='Justin', age=26}, ComparableUser{username='Charles', age=32}]
after sorted:[ComparableUser{username='Justin', age=26}, ComparableUser{username='Henry', age=27}, ComparableUser{username='Charles', age=32}]
```
If you use JDK1.8+ you can write `Comparator` with lambda expression.
```
List<User> userList = new LinkedList<>();
userList.add(new User("Henry", 27));
userList.add(new User("Justin", 26));
userList.add(new User("Charles", 32));
System.out.println("before sorted:" + userList);
Collections.sort(userList, (o1, o2) -> (o1.getAge() < o2.getAge()) ? -1 : ((o1.getAge() == o2.getAge()) ? 0 : 1));
System.out.println("after sorted:" + userList);
```
**2. Make objects implement `Comparable`**

ComparableUser
```java
public class ComparableUser implements Comparable<ComparableUser> {

    public ComparableUser(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    private String username;
    private Integer age;

    //getter and setter methods

    @Override
    public int compareTo(ComparableUser o) {
        return this.age.compareTo(o.age);
    }

    @Override
    public String toString() {
        return "ComparableUser{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
```
You can use `Collections.sort()` to sort objects which implements `Comparable` interface.
```java
List<ComparableUser> comparableUsers = new LinkedList<>();
comparableUsers.add(new ComparableUser("Henry", 27));
comparableUsers.add(new ComparableUser("Justin", 26));
comparableUsers.add(new ComparableUser("Charles", 32));
System.out.println("before sorted:" + comparableUsers);
Collections.sort(comparableUsers);
System.out.println("after sorted:" + comparableUsers);
```
The output is like the following.
```java
before sorted:[User{age=27, username='Henry'}, User{age=26, username='Justin'}, User{age=32, username='Charles'}]
after sorted:[User{age=26, username='Justin'}, User{age=27, username='Henry'}, User{age=32, username='Charles'}]
```
Objects will be sorted automatically when you put them into `TreeSet`.
```java
Set<ComparableUser> userSet = new TreeSet<>();
userSet.add(new ComparableUser("Henry", 27));
userSet.add(new ComparableUser("Justin", 26));
userSet.add(new ComparableUser("Charles", 32));
System.out.println(userSet);
```
The output is like following.
```
[ComparableUser{username='Justin', age=26}, ComparableUser{username='Henry', age=27}, ComparableUser{username='Charles', age=32}]
```
 