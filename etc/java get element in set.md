# Java get element in set
There are a lot of ways to get one element from set. I do not recommend you to do this. If you need get one of them
use `List` instead.
```java
public class TestSet {
    public static void main(String[] args) {
        Set<String> setStr = new HashSet<>();
        setStr.add("test1");
        setStr.add("test2");

        for (String target0 : setStr) {
            System.out.println(target0);
            break;
        }

        String target1 = (String) setStr.toArray()[0];

        List<String> listStr = new ArrayList<>();
        listStr.addAll(setStr);
        String target2 = listStr.get(0);

        String target3 = setStr.iterator().next();
    }
}
```