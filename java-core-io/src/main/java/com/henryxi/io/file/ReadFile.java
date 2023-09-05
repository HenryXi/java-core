package com.henryxi.io.file;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


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
