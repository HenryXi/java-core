# Java8 stream collect list to map in order
We can convert list to map easily in Java8 by using `stream`. The sample code is like following.
```java
List<User> users = new ArrayList<>();
users.add(new User("henry", 28));
users.add(new User("justin", 27));
users.add(new User("Mathew", 26));
Map<String, Integer> nameAgeMap = users.stream().collect(Collectors.toMap(User::getName, User::getAge));
System.out.println(nameAgeMap);
```
The output is here.
```
{henry=28, Mathew=26, justin=27}
```
The order is different from `List<User>`, If you want to get the map order same with `List<User>` you have to implement
the `toMap` method of `Collectors`. What you need to do is using `LinkedHashMap` replace `HashMap` in `toMap` method.
```java
List<User> users = new ArrayList<>();
users.add(new User("henry", 28));
users.add(new User("justin", 27));
users.add(new User("Mathew", 26));
LinkedHashMap<String, Integer> nameAgeOrderMap = users.stream().collect(Collectors.toMap(User::getName, User::getAge, (u, v) -> {
    throw new IllegalStateException(String.format("Duplicate key %s", u));
}, LinkedHashMap::new));
System.out.println(nameAgeOrderMap);
```
The output is here.
```
{henry=28, justin=27, Mathew=26}
```
The same order with `List<User>`.

EOF