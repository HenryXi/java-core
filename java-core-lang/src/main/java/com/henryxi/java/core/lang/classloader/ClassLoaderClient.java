package com.henryxi.java.core.lang.classloader;

import java.lang.reflect.Method;
import java.util.Arrays;

public class ClassLoaderClient {
    public static void main(String[] args) throws Exception {
        args = (String[]) Arrays.asList("com.henryxi.java.core.lang.classloader.Foo", "1212", "1313").toArray();
        String progClass = args[0];
        String progArgs[] = new String[args.length - 1];
        System.arraycopy(args, 1, progArgs, 0, progArgs.length);

        CustomClassLoader ccl = new CustomClassLoader(ClassLoaderClient.class.getClassLoader());
        Class clas = ccl.loadClass(progClass);
        Class mainArgType[] = {(new String[0]).getClass()};
        Method main = clas.getMethod("main", mainArgType);
        Object argsArray[] = {progArgs};
        main.invoke(null, argsArray);

        // Below method is used to check that the Foo is getting loaded
        // by our custom class loader i.e CCLoader
        Method printCL = clas.getMethod("printCL", null);
        printCL.invoke(null, new Object[0]);


    }
}
