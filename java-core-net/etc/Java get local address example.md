# Java get local address example
I recently need to get a local ip when doing a feature. The following code perfectly implements this function. It’s very 
simple, just a few lines of code.
```java
public class GetLocalAddressClient {
    public static void main(String args[]) throws Exception {
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println("IP Address:- " + inetAddress.getHostAddress());
        System.out.println("Host Name:- " + inetAddress.getHostName());
    }
}
```
EOF