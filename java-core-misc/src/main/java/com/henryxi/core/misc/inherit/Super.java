package com.henryxi.core.misc.inherit;

public class Super {
    public void execute(){
        System.out.println("Super");
    }

    public static void main(String[] args) {
        Super c = new Child();
        c.execute();
    }
}
