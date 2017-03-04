# Java remove all null elements from list
If there are more than one null elements in list `list.remove()` method can not remove all of them. Use `list.removeAll()`
to remove them. Example code is like following.
```java
public static void main(String[] args) {
    List<String> list1 = new ArrayList<>();
    list1.add(null);
    list1.add(null);
    list1.add("2");
    list1.add("3");
    list1.remove(null);
    System.out.println(list1);//[null, 2, 3]

    List<String> list2 = new ArrayList<>();
    list2.add(null);
    list2.add(null);
    list2.add("2");
    list2.add("3");
    list2.removeAll(Collections.singletonList(null));
    System.out.println(list2);//[2, 3]
}
```
