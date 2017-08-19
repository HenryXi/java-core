# Java8 convert list to map
Before Java8 if you need convert list to map you have to iterate over the list. Java8 provide `stream` to help 
you iterate over the list. You can convert list to map by using `stream` with only one line of code. 

**Old way**
```java
List<User> userList = new ArrayList<>();
userList.add(new User(1, "Henry"));
userList.add(new User(2, "Justin"));

Map<Integer, User> map = new HashMap<>();
for (User user : userList) {
    map.put(user.getId(), user);
}
System.out.println(map);
```

**Use stream**
```java
List<User> userList = new ArrayList<>();
userList.add(new User(1, "Henry"));
userList.add(new User(2, "Justin"));

Map<Integer, User> mapByStream = userList.stream().collect(Collectors.toMap(new Function<User, Integer>() {
    @Override
    public Integer apply(User t) {
        return t.getId();
    }
}, new Function<User, User>() {
    @Override
    public User apply(User user) {
        return user;
    }
}));
System.out.println(mapByStream);
```

The `stream` method help you iterate the list. `collect` method need a `Collector` to convert list to map.
`Collectors.toMap()` means this collector need two parameters: key and value. For every user in stream, the key
is its id and the value is itself.

**Use lambda simplify code**

The code of above can be more simplified with lambda.
```java
List<User> userList = new ArrayList<>();
userList.add(new User(1, "Henry"));
userList.add(new User(2, "Justin"));

Map<Integer, User> mapByStream = userList.stream().collect(Collectors.toMap(User::getId, user -> user));
System.out.println(mapByStream);
```

EOF