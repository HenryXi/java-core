# Java retainAll example
`retainAll` method is used to remove the elements which not in both collections. The example code is here.
```java
public class RetainAllClient {
    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        a.add("1");
        a.add("2");
        a.add("3");
        a.add("4");
        List<String> b = new ArrayList<>();
        b.add("1");
        b.add("2");
        b.add("4");
        b.add("5");
        System.out.println(a.retainAll(b));
        System.out.println(a);
        System.out.println(b);
    }
}
```
`a.retainAll(b)` means remove the elements which are not in both `a` and `b` list. The element "5" is only in `b` list, remove
it from `a` list after calling the method. The output is like following.
```
true
[1, 2, 4]
[1, 2, 4, 5]
```
The return of `retainAll` means the original collection is changed or not.

EOF