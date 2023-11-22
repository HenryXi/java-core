# Java large file line by line read example

Large file reads are very memory intensive. You can use `BufferedReader` to read the contents of the file line by line.

```java
public class ReadFile {
    public static void main(String[] args) throws Exception {
        File file = new File("D:\\testData\\www.csdn.net.sql");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
```

EOF