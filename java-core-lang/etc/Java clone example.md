# Java clone example
We can use `clone` method to clone an object. This is a native method in `Object` (make it faster). If you want to use this method you need
to implement `cloneable` interface. If you want to use this method in different package do not forget change this method 
to be `public`. The example code is here.
```java
public class Address implements Cloneable {
    private String country;
    private String city;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public Address clone() throws CloneNotSupportedException {
        return (Address) super.clone();
    }
}

public class User implements Cloneable {
    private String name;
    private int age;
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public User clone() throws CloneNotSupportedException {
        return (User) super.clone();
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}

public class DeepCopyUser implements Cloneable {
    private String name;
    private int age;
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public DeepCopyUser clone() throws CloneNotSupportedException {
        DeepCopyUser copyUser = (DeepCopyUser) super.clone();
        copyUser.setAddress(address.clone());
        return copyUser;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}

public class CloneClient {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("-------use copy-------");
        testCopy();
        System.out.println("-------use deep copy-------");
        testDeepCopy();
    }

    private static void testCopy() throws CloneNotSupportedException {
        Address beijing = new Address();
        beijing.setCountry("China");
        beijing.setCity("beijing");
        User henry = new User();
        henry.setName("Henry");
        henry.setAge(30);
        henry.setAddress(beijing);
        User cloneHenry = henry.clone();
        System.out.println("Henry:" + henry);
        System.out.println("Henry copy:" + cloneHenry);
        System.out.println("change Henry's address");
        Address newAddress = henry.getAddress();
        newAddress.setCountry("USA");
        newAddress.setCity("San Francisco");
        System.out.println("Henry:" + henry);
        System.out.println("Henry copy:" + cloneHenry);
    }

    private static void testDeepCopy() throws CloneNotSupportedException {
        Address beijing = new Address();
        beijing.setCountry("China");
        beijing.setCity("beijing");
        DeepCopyUser henry = new DeepCopyUser();
        henry.setName("Henry");
        henry.setAge(30);
        henry.setAddress(beijing);
        DeepCopyUser cloneHenry = henry.clone();
        System.out.println("Henry:" + henry);
        System.out.println("Henry copy:" + cloneHenry);
        System.out.println("change Henry's address");
        Address newAddress = henry.getAddress();
        newAddress.setCountry("USA");
        newAddress.setCity("San Francisco");
        System.out.println("Henry:" + henry);
        System.out.println("Henry copy:" + cloneHenry);
    }
}
```
The output is here.
```
-------use copy-------
Henry:User{name='Henry', age=30, address=Address{country='China', city='beijing'}}
Henry copy:User{name='Henry', age=30, address=Address{country='China', city='beijing'}}
change Henry's address
Henry:User{name='Henry', age=30, address=Address{country='USA', city='San Francisco'}}
Henry copy:User{name='Henry', age=30, address=Address{country='USA', city='San Francisco'}}
-------use deep copy-------
Henry:User{name='Henry', age=30, address=Address{country='China', city='beijing'}}
Henry copy:User{name='Henry', age=30, address=Address{country='China', city='beijing'}}
change Henry's address
Henry:User{name='Henry', age=30, address=Address{country='USA', city='San Francisco'}}
Henry copy:User{name='Henry', age=30, address=Address{country='China', city='beijing'}}
```
`clone` method works well for primitive type(`int`, `boolean`, etc.). `String` is not primitive type but it is immutable.
Both of them are OK. If you want to copy reference types like `Address`. We should use `Deep Copy` to avoid original
and cloned class using the same reference.

EOF 