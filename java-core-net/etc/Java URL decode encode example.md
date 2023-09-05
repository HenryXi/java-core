# Java URL decode encode example
When you send `GET` request to server, you need to encode the data which contained in the url.In this way can make sure the data 
you send could be received by server correctly. Certainly, serve has to decode the data before using them. The example is like 
following.
```java
public class URLDecodeEncodeClient {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String tobeEncode = "aq/iif25QpMTUi8rg4EuFY3+/YgZQzIYAsa/g+JD8Ck=";
        String afterEncode = URLEncoder.encode(tobeEncode, "UTF-8");
        System.out.println("afterEncode:" + afterEncode);
        String afterDecode = URLDecoder.decode(afterEncode, "UTF-8");
        System.out.println("afterDecode:" + afterDecode);
    }
}
```
EOF