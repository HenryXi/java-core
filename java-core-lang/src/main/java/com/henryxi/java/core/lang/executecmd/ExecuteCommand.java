package com.henryxi.java.core.lang.executecmd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

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
