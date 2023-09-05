# Java understand IncompatibleClassChangeError
When I use thrift generate classes I got `IncompatibleClassChangeError`. This error means the class you depends has changed.
Let's say your project depend on `ClassA.class`. When `ClassA.class` upgrades to new version (add some new methods or fields).
It's name doesn't change. You project can use both old and new version of this class. This is "[Binary Compatibility](https://docs.oracle.com/javase/specs/jls/se7/html/jls-13.html)". 
But when the new version change one static field to no-static. `IncompatibleClassChangeError` will be thrown. 

Let's generate `IncompatibleClassChangeError`. Prepare two class like following.

```java
public class Test{
	public static void main(String[] args){
		DependClass depend = new DependClass();
		System.out.println(depend.luck);
	}
}

public class DependClass{
	public static String luck="luck";
}
```

Compile both classes and you will get two class file
```bash
[root@localhost tmp]# javac Test.java 
[root@localhost tmp]# javac DependClass.java
```

Run `Test` you will get the following output.
```bash
[root@localhost tmp]# java Test
luck
```
Change field luck to no-static.
```java
public class DependClass{
	public String luck="luck";
}
```
compile and run Test again.
```bash
[root@localhost tmp]# javac DependClass.java 
[root@localhost tmp]# java Test
Exception in thread "main" java.lang.IncompatibleClassChangeError: Expected non-static field DependClass.luck
	at Test.main(Test.java:4)
```

EOF