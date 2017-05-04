# Java finally example
The code in `finally` block will always be executed except invoke `System.exit()` method.
The example code is like following.

**Test nest finally** 
```java
public class TestFinally {
    public static void main(String[] args) throws Exception {
        String test = "test";
        try {
            try {
                if (test.equals("test")) {
                    throw new Exception("test");
                }
            } finally {
                System.out.println("first finally");
            }
        } catch (Exception e) {
            System.out.println("throw exception");
        } finally {
            System.out.println("finally");
        }
    }
}
```
The output is like following.
```
first finally
throw exception
finally
```

**Test finally and return**
```java
public class TestFinallyReturn {
    public static void main(String[] args) throws Exception {
        try {
            System.out.println("begin");
            int i = 10 + 1;
            if (i > 10) {
                return;
            }
            System.out.println("not here");
        } finally {
            System.out.println("finally");
        }
    }
}
```
The output is like following.
```
begin
finally
```

**Test finally and `System.exit()`**
```java
public class TestFinallySystemExit {
    public static void main(String[] args) {
        try{
            System.out.println("begin");
            System.exit(0);
        }finally {
            System.out.println("this is finally");
        }
    }
}
```
The output is like following.
```
begin
```

EOF