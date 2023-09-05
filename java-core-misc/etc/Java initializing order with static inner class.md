# Java initializing order with static inner class
In this page I will show you when static inner class is initialized. I write a demo to help you to understand it. All
static fields (include inner class) is initialized when the class is loaded.

**Code**
```java
public class Super {
    public Super() {
        System.out.println("Super constructor");
    }

    {
        System.out.println("Super block");
    }

    static {
        System.out.println("Super static");
    }
}

public class Child extends Super {

    {
        System.out.println("Child block");
    }

    static {
        System.out.println("Child static");
    }

    private static class InnerStaticClass {
        private static Child instance = new Child();
    }

    private Child() {
        System.out.println("Child constructor");
    }

    public static Child getInstance() {
        System.out.println("Child static method:getInstance");
        return InnerStaticClass.instance;
    }
}

public class Client {
    public static void main(String[] args) {
        Child.getInstance();
        System.out.println("----get instance second time----");
        Child.getInstance();
    }
}
```
The output is here
```
Super static
Child static
Child static method:getInstance
Super block
Super constructor
Child block
Child constructor
----get instance second time----
Child static method:getInstance
``` 
For the order of initializing you need to remember following rules:static first. Only in this way we can invoke static method
without creating instance.

static field -> block -> constructor

EOF