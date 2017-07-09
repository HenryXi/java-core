# Java execute command example
Sometimes we need to execute commands in Java. I will show you how to do it in this blog. The code is like following.
I assume you use Windows and have installed JDK in your environment. If you use Linux or Mac call `runtime.exec("java")`
will execute java command.

```java
public class ExecuteCommand {
    public static void main(String[] args) throws IOException, InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec("C:\\Program Files\\Java\\jdk1.6.0_45\\bin\\java.exe");
        InputStream is = process.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line;
        System.out.printf("Output of running %s is:", Arrays.toString(args));
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }
}
```
We can get the execute result(`process.getInputStream()`) or the error(`process.getErrorStream()`) message 
from `Process` class. 

EOF