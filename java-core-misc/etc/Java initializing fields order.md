# Java initializing fields order
If you can not make sure the execution order of `block`, `static-block` and `constructor`. This blog will write a demo to
help you understand the order of initializing fields.

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
        System.out.println("static Super");
    }
}

public class Child extends Super {
    public Child() {
        System.out.println("Child constructor");
    }

    {
        System.out.println("Child block");
    }

    static {
        System.out.println("static Child");
    }
}

public class Client {
    public static void main(String[] args) {
        new Child();
        System.out.println("----init second child----");
        new Child();
    }
}
```
The output is here
```
static Super
static Child
Super block
Super constructor
Child block
Child constructor
```

There are several rules when initializing fields
1. `statkc-block` will executed before the **Object** first used.
2. `block` will executed firstly when the instance is created.
3. `constructor` will executed when all `block`(static and normal `block`) execute finish. 