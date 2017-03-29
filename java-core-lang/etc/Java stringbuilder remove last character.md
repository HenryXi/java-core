# Java stringbuilder remove last character
Using `StringBuilder` or `StringBuffer` is more efficient then `String` when you need append some strings. There
is a problem when use them in loop. We have to remove the last character when end the loop. Today I will show you
how to remove last character when you use `StringBuilder` or `StringBuffer`.

**TODO** We want split the sentence with ",".


When you use `StringBuilder` the code is like following. The sample code of 
`StringBuffer` is similar with `StringBuilder`. You have to count the length of `StringBuilder` and use `subString`
method to get the string without last character.
```java
public static void main(String[] args) {
    String[] stringArray = "this is a sentence".split(" ");
    StringBuilder sb = new StringBuilder();
    for (String string : stringArray) {
        sb.append(string).append(",");
    }
    System.out.println("result:" + sb.toString().substring(0, sb.toString().length() - 1));
}
```


**Recommend to use `StringJoiner` (need JDK1.8+)**

It is easy to use `StringJoiner` split the sentence with ",". The sample code is like following.
```java
public static void main(String[] args) {
    String[] stringArray = "this is a sentence".split(" ");
    StringJoiner stringJoiner = new StringJoiner(",");
    for (String string : stringArray) {
        stringJoiner.add(string);
    }
    System.out.println("result:" + stringJoiner);
}
```