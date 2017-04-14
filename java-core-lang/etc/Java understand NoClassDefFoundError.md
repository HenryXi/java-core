# Java understand NoClassDefFoundError
Today I got `NoClassDefFoundError` when I test my new feature. The stack information is like following.
```
java.lang.NoClassDefFoundError: Could not initialize class <my class>
```
This error will throw when JVM tries to load the class but can not find it. In other words, this class can be found in
compile time but can not be found in runtime. The doc of this error is like following.
> Thrown if the Java Virtual Machine or a ClassLoader instance tries to load in the definition of a class (as part 
> of a normal method call or as part of creating a new instance using the <code>new</code> expression) and no definition 
> of the class could be found.

I'm confused. **How did it happen ?** When I found the code like following I understand.
```java
public class TestNoClassDefFoundError {
    public static void main(String[] args) {
        try{
            TargetClass t = new TargetClass();
        }catch (Throwable t){
            System.out.println(t);
        }
        TargetClass t = new TargetClass();
    }
}

public class TargetClass {
    static {
        int i = 1 / 0;
    }
}
```
Run the main method of `TestNoClassDefFoundError`. `ExceptionInInitializerError` will be thrown when initialize `TargetClass`
first time. When you ignore this error and use `TargetClass` second time `NoClassDefFoundError` will be thrown. 
First time JVM tells you "can not initialize" but you don't care and ignore the error, second time JVM can not find
this class.

**How to avoid**

DO NOT ignore any exception in static block.  