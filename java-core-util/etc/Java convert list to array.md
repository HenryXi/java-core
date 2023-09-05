# Java convert list to array
We can use `Arrays.asList()` to init an array with values. This page will show you how to convert `List<T>` to `T[]`. For
example convert `List<String>` to `String[]`. The code is here.
```java
public class ListToArrayClient {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("1", "2", "3");
        System.out.println(list);
        String[] strings = list.toArray(new String[0]);
        for (String s : strings) {
            System.out.println(s);
        }
    }
}
```
The output is here
```
[1, 2, 3]
1
2
3
```
It is very useful when you need pass params to the method like this `print(String... params)`. 
```java
public class ListToArrayClient {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("1", "2", "3");
        System.out.println(list);
        String[] strings = list.toArray(new String[0]);
        print(strings);
    }

    private static void print(String... params) {
        for (String s : params) {
            System.out.println(s);
        }
    }
}
```

EOF