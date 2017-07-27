package com.henryxi.io;

import java.io.File;
import java.io.IOException;

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
