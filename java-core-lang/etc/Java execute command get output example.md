# Java execute command get output example
The `getInputStream()` method of `Process` return the result of what you executed. If there is an error when you 
invoke the command with `Process`, using `getErrorStream()` to get the information. The example code is here.
```java
public class ExecuteCommand {
    public static void main(String[] args) throws Exception {
        Runtime rt = Runtime.getRuntime();
        Process succProcess = rt.exec("echo hi");
        if (succProcess.waitFor() == 0) {
            System.out.println("command executed succ, output is like following:");
            BufferedReader reader = new BufferedReader(new InputStreamReader(succProcess.getInputStream()));
            String commandOutput = "";
            while (commandOutput != null) {
                commandOutput = reader.readLine();
                System.out.println(commandOutput);
            }
        }
        Process failProcess = rt.exec("ls --xxx");
        if (failProcess.waitFor() != 0) {
            System.out.println("command executed with error exit value:" + failProcess.exitValue() + ",error info is like following");
            BufferedReader reader = new BufferedReader(new InputStreamReader(failProcess.getErrorStream()));
            String commandOutput = "";
            while (commandOutput != null) {
                commandOutput = reader.readLine();
                System.out.println(commandOutput);
            }
        }
    }
}
```
output
```
command executed succ, output is like following:
hi
null
command executed with error exit value:2,error info is like following
ls: unrecognized option '--xxx'
Try `ls --help' for more information.
null
```

EOF




 
