# Java8 stream groupingBy example
When we want to group the list data, we have to write some tedious code in the old version of the JDK. For example we want
to group list of people by age. The code is like this before JDK8.
```java
private static void oldGroupingBy(List<User> users) {
    Map<Integer, List<User>> ageUsersMap = new HashMap<>();
    for (User user : users) {
        List<User> groupOfUser = ageUsersMap.get(user.getAge());
        if (groupOfUser != null) {
            groupOfUser.add(user);
            continue;
        }
        groupOfUser = new ArrayList<>();
        groupOfUser.add(user);
        ageUsersMap.put(user.getAge(), groupOfUser);
    }
    System.out.println("age users map:" + ageUsersMap);
}
```
Use stream and `Collectors.groupingBy` can make it easy.
```java
private static void newGroupingBy(List<User> users) {
    Map<Integer, List<User>> ageUsersMap = users.stream().collect(Collectors.groupingBy(User::getAge));
    System.out.println("age users map:" + ageUsersMap);

    Map<Integer, Long> ageCountMap = users.stream().collect(Collectors.groupingBy(User::getAge, Collectors.counting()));
    System.out.println("age count map:" + ageCountMap);
}
```
The complete code is as follows
```java
public class StreamGroupingByClient {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("henry", 30));
        users.add(new User("justin", 30));
        users.add(new User("mathew", 27));
        oldGroupingBy(users);
        newGroupingBy(users);
    }

    private static void newGroupingBy(List<User> users) {
        Map<Integer, List<User>> ageUsersMap = users.stream().collect(Collectors.groupingBy(User::getAge));
        System.out.println("age users map:" + ageUsersMap);

        Map<Integer, Long> ageCountMap = users.stream().collect(Collectors.groupingBy(User::getAge, Collectors.counting()));
        System.out.println("age count map:" + ageCountMap);
    }

    private static void oldGroupingBy(List<User> users) {
        Map<Integer, List<User>> ageUsersMap = new HashMap<>();
        for (User user : users) {
            List<User> groupOfUser = ageUsersMap.get(user.getAge());
            if (groupOfUser != null) {
                groupOfUser.add(user);
                continue;
            }
            groupOfUser = new ArrayList<>();
            groupOfUser.add(user);
            ageUsersMap.put(user.getAge(), groupOfUser);
        }
        System.out.println("age users map:" + ageUsersMap);
    }
}
```
output
```
age users map:{27=[User{name='mathew', age=27}], 30=[User{name='henry', age=30}, User{name='justin', age=30}]}
age users map:{27=[User{name='mathew', age=27}], 30=[User{name='henry', age=30}, User{name='justin', age=30}]}
age count map:{27=1, 30=2}
```
