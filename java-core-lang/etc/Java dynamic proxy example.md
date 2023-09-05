# Java dynamic proxy example
`Dynamic proxy` is commonly used in popular java frameworks, such as `Spring`, `MyBatis` and so on. There are other ways to 
implement proxy by using aspect or javassit and so on third part frameworks. In this page I will show you `JDK` dynamic proxy.

```java
public class Client {
    static public void main(String[] args) throws Throwable {
        TargetClass rs = new TargetClass();
        InvocationHandler handler = new Handler(rs);
        Class cls = rs.getClass();
        Interface proxy = (Interface) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), handler);
        proxy.request();
    }
}

public interface Interface {
    void request();
}

public class Handler implements InvocationHandler {
    private Interface sub;

    public Handler() {
    }

    public Handler(Interface obj) {
        sub = obj;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before calling real method:" + method.getName());
        method.invoke(sub, args);
        System.out.println("after calling real method:" + method.getName());
        return null;
    }
}

public class TargetClass implements Interface {
    public TargetClass(){}
    public void request() {
        System.out.println("From real subject.");
    }
}
```
The output of Client is here
```
before calling real method:request
From real subject.
after calling real method:request
```
To use JDK dynamic proxy the target class must implement interface. Using `Proxy.newProxyInstance` to create proxy object 
in runtime. We can add extra operation before or after during origin method invoked. After creating proxy object to invoke 
its method just like invoking method of target object.

EOF 