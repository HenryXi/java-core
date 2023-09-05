# Java could not find or load main class
`Error: Could not find or load main class` For this problem, not only beginners of Java will encounter it. When developers 
with many years of work experience leave the IDE and want to run java manually, they may also be troubled by this problem.
If you add `package` in your class then you need put it in the same directory.
```java
package com.henryxi.java.core.lang.classpath;

public class ClassPathClient {
    public static void main(String[] args) {
        System.out.println("hello java class path");
    }
}
```
To run this class you need make directory `./com/henryxi/java/core/lang/classpath` and put the class file in it. 
```bash
[root@localhost tmp]# ll
total 4
-rw-r--r--. 1 root root 184 Jun 21 23:13 ClassPathClient.java
[root@localhost tmp]# ll
total 4
-rw-r--r--. 1 root root 184 Jun 21 23:13 ClassPathClient.java
[root@localhost tmp]# javac ClassPathClient.java 
[root@localhost tmp]# ll
total 8
-rw-r--r--. 1 root root 482 Jun 21 23:23 ClassPathClient.class
-rw-r--r--. 1 root root 184 Jun 21 23:13 ClassPathClient.java
drwxr-xr-x. 2 root root   6 Jun 21 23:23 hsperfdata_root
[root@localhost tmp]# mkdir ./com/henryxi/java/core/lang/classpath -p
[root@localhost tmp]# cp ClassPathClient.class ./com/henryxi/java/core/lang/classpath/
[root@localhost tmp]# java com/henryxi/java/core/lang/classpath/ClassPathClient
hello java class path
```

EOF