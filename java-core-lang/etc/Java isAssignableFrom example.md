# Java isAssignableFrom example
The `isAssignableFrom` method is used to judge the relationship of two classes. This method can tell you whether
A is the subclass of B. or A class implement B interface. The example code is here.
```java
public class TestImpClazz implements TestInterface {
}

interface TestInterface {
}

public class TestSubClazz extends TestImpClazz {
}

public class TestIsAssignedFrom {
    public static void main(String[] args) {
        System.out.println(TestInterface.class.isAssignableFrom(TestImpClazz.class));
        System.out.println(TestImpClazz.class.isAssignableFrom(TestSubClazz.class));
        System.out.println(TestImpClazz.class.isAssignableFrom(TestImpClazz.class));

        System.out.println(TestImpClazz.class.isAssignableFrom(TestInterface.class));
        System.out.println(TestSubClazz.class.isAssignableFrom(TestImpClazz.class));
    }
}
```
The output:
```
true
true
true
false
false
```

EOF
