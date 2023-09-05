package com.henryxi.java.core.lang.command;

import java.io.BufferedReader;
import java.io.InputStreamReader;

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
