# Java stack trace disappear
I recently found a lot of exceptions without stack information when I looked at the logs. There is only one exception name 
in the log, and there is no complete stack information. I know the reason after google. To improve efficiency, the JVM hides 
duplicate stack information. More information can be found [here](https://www.oracle.com/technetwork/java/javase/relnotes-139183.html) 

> The compiler in the server VM now provides correct stack backtraces for all "cold" built-in exceptions. For performance 
purposes, when such an exception is thrown a few times, the method may be recompiled. After recompilation, the compiler 
may choose a faster tactic using preallocated exceptions that do not provide a stack trace. To disable completely the use 
of preallocated exceptions, use this new flag: -XX:-OmitStackTraceInFastThrow.

We reproduce this process with the following code.
```java
public class ExceptionStackTraceClient {
    public static void main(String[] args) {
        ExceptionStackTraceClient client = new ExceptionStackTraceClient();
        client.throwException();
    }

    private void throwException() {
        for (int i = 0; i < 1_000_000_000; i++) {
            try {
                ((Object) null).getClass();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
```
Run the following code and you will get the NPE and this exception detailed stack information.
```
......
java.lang.NullPointerException
	at com.henryxi.java.core.lang.exception.ExceptionStackTraceClient.throwException(ExceptionStackTraceClient.java:12)
	at com.henryxi.java.core.lang.exception.ExceptionStackTraceClient.main(ExceptionStackTraceClient.java:6)
java.lang.NullPointerException
	at com.henryxi.java.core.lang.exception.ExceptionStackTraceClient.throwException(ExceptionStackTraceClient.java:12)
	at com.henryxi.java.core.lang.exception.ExceptionStackTraceClient.main(ExceptionStackTraceClient.java:6)
java.lang.NullPointerException
	at com.henryxi.java.core.lang.exception.ExceptionStackTraceClient.throwException(ExceptionStackTraceClient.java:12)
	at com.henryxi.java.core.lang.exception.ExceptionStackTraceClient.main(ExceptionStackTraceClient.java:6)
......
......
......
java.lang.NullPointerException
java.lang.NullPointerException
java.lang.NullPointerException
```
But the stack information will disappear when the log is output for a while. If you don't want the JVM to swallow the 
stack information, then you need to increase the following JVM parameters.
```
-XX:-OmitStackTraceInFastThrow.
```

EOF