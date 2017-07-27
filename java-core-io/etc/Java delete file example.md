# Java delete file example
Deleting file is a common daily operations. I will show you how to delete file in java. The example code is here.
```java
public class DeleteFile {
    public static void main(String[] args) throws IOException {
        File noExistFile = new File("noExist.txt");
        boolean deleteNoExistResult = noExistFile.delete();
        System.out.println("delete no exist file result: " + deleteNoExistResult);
        File tobeDeleted = new File("/tmp/tobeDeleted.txt");
        boolean createFileResult = tobeDeleted.createNewFile();
        System.out.println("create file result:" + createFileResult);
        boolean deleteExistResult = tobeDeleted.delete();
        System.out.println("delete exist file result: " + deleteExistResult);
    }
}
```
The result of deleting is "true" means delete this file successfully; otherwise delete failed.

output
```
delete no exist file result: false
create file result:true
delete exist file result: true
```

EOF