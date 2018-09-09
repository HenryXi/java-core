package com.henryxi.core.misc.process;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class ProcessClient {
    public static void main(String[] args) {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        String name = runtimeMXBean.getName();
        System.out.println(name);
    }
}
