# Java serialization when object changed
It is easy to serialize object to byte array and deserialize byte array to object. Today I will show you how to serialize
and deserialize object when it changed.

**1. Preparation**

The pom file is like following.
```xml
<dependencies>
    <dependency>
        <groupId>org.apache.commons</groupId>
        <artifactId>commons-lang3</artifactId>
        <version>3.4</version>
    </dependency>
    <dependency>
        <groupId>commons-io</groupId>
        <artifactId>commons-io</artifactId>
        <version>2.4</version>
    </dependency>
</dependencies>
```
The first version of `User` class is like following.
```java
public class User implements Serializable {

    private static final long serialVersionUID = -6704164414515767927L;

    private String name;
    private String address;
    private String age;
    
    //getter and setter methods

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
```
Serialize object to byte array and save it into file. 
```java
public class TestSerialize {
    public static void main(String[] args) throws IOException {
        User user = new User();
        user.setName("henry");
        user.setAddress("beijing");
        user.setAge("27");
        FileUtils.writeByteArrayToFile(new File("/user_version1.txt"), SerializationUtils.serialize(user));
    }
}
```
**2. Change fields of `User` class**

Add `test` field and delete age field.
```java
public class User implements Serializable {

    private static final long serialVersionUID = -6704164414515767927L;

    private String name;
    private String address;
    private String test;

    //getter and setter methods

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", test='" + test + '\'' +
                '}';
    }
}
```
Read byte array from "user_version1.txt" and deserialize to new version of `User`.
```java
public class TestDeserialize {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/user_version1.txt");
        byte[] data = Files.readAllBytes(path);
        User user = SerializationUtils.deserialize(data);
        System.out.println(user);
    }
}
```
The output is like following.
```
User{name='henry', address='beijing', test='null'}
```

**3. Change the value of serialVersionUID**
```java
public class User implements Serializable {

    private static final long serialVersionUID = -6L;

    private String name;
    private String address;
    private String age;

    //getter and setter methods

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
```
Deserialize this object again. We got the Exception like following.
```
Exception in thread "main" org.apache.commons.lang3.SerializationException: java.io.InvalidClassException: com.henryxi.serialize.User; local class incompatible: stream classdesc serialVersionUID = -6704164414515767927, local class serialVersionUID = -6
	at org.apache.commons.lang3.SerializationUtils.deserialize(SerializationUtils.java:231)
	at org.apache.commons.lang3.SerializationUtils.deserialize(SerializationUtils.java:267)
	at com.henryxi.serialize.TestDeserialize.main(TestDeserialize.java:14)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:497)
	at com.intellij.rt.execution.application.AppMain.main(AppMain.java:144)
Caused by: java.io.InvalidClassException: com.henryxi.serialize.User; local class incompatible: stream classdesc serialVersionUID = -6704164414515767927, local class serialVersionUID = -6
	at java.io.ObjectStreamClass.initNonProxy(ObjectStreamClass.java:616)
	at java.io.ObjectInputStream.readNonProxyDesc(ObjectInputStream.java:1623)
	at java.io.ObjectInputStream.readClassDesc(ObjectInputStream.java:1518)
	at java.io.ObjectInputStream.readOrdinaryObject(ObjectInputStream.java:1774)
	at java.io.ObjectInputStream.readObject0(ObjectInputStream.java:1351)
	at java.io.ObjectInputStream.readObject(ObjectInputStream.java:371)
	at org.apache.commons.lang3.SerializationUtils.deserialize(SerializationUtils.java:223)
	... 7 more
```
**4. Delete the value of serialVersionUID**
```java
public class User implements Serializable {

    private String name;
    private String address;
    private String age;

    //getter and setter methods

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
```
Deserialize this object again. We got the same Exception.
```
Exception in thread "main" org.apache.commons.lang3.SerializationException: java.io.InvalidClassException: com.henryxi.serialize.User; local class incompatible: stream classdesc serialVersionUID = -6704164414515767927, local class serialVersionUID = 2510146339395188803
	at org.apache.commons.lang3.SerializationUtils.deserialize(SerializationUtils.java:231)
	at org.apache.commons.lang3.SerializationUtils.deserialize(SerializationUtils.java:267)
	at com.henryxi.serialize.TestDeserialize.main(TestDeserialize.java:14)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:497)
	at com.intellij.rt.execution.application.AppMain.main(AppMain.java:144)
Caused by: java.io.InvalidClassException: com.henryxi.serialize.User; local class incompatible: stream classdesc serialVersionUID = -6704164414515767927, local class serialVersionUID = 2510146339395188803
	at java.io.ObjectStreamClass.initNonProxy(ObjectStreamClass.java:616)
	at java.io.ObjectInputStream.readNonProxyDesc(ObjectInputStream.java:1623)
	at java.io.ObjectInputStream.readClassDesc(ObjectInputStream.java:1518)
	at java.io.ObjectInputStream.readOrdinaryObject(ObjectInputStream.java:1774)
	at java.io.ObjectInputStream.readObject0(ObjectInputStream.java:1351)
	at java.io.ObjectInputStream.readObject(ObjectInputStream.java:371)
	at org.apache.commons.lang3.SerializationUtils.deserialize(SerializationUtils.java:223)
	... 7 more
```

**5. Conclusion**

1. Deserializing will be success when we only change the field of object. removed field -> lost , new field -> default value.
2. Deserializing will be fail when we change `serialVersionUID`.
3. Deserializing will be fail when we delete `serialVersionUID`.

`serialVersionUID` must be defined in the object when you need serialize and deserialize object. If there is no `serialVersionUID` or 
the value of `serialVersionUID` changed deserializing will be fail.

