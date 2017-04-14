package com.henryxi.java.core.lang.noclassdeffound;

public class TestNoClassDefFoundError {
    public static void main(String[] args) {
        try{
            TargetClass t = new TargetClass();
        }catch (Throwable t){
            System.out.println(t);
        }
        TargetClass t = new TargetClass();
    }
}

