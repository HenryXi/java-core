package com.henryxi.java.core.lang.object.clone;

public class CloneClient {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("-------use copy-------");
        testCopy();
        System.out.println("-------use deep copy-------");
        testDeepCopy();
    }

    private static void testCopy() throws CloneNotSupportedException {
        Address beijing = new Address();
        beijing.setCountry("China");
        beijing.setCity("beijing");
        User henry = new User();
        henry.setName("Henry");
        henry.setAge(30);
        henry.setAddress(beijing);
        User cloneHenry = henry.clone();
        System.out.println("Henry:" + henry);
        System.out.println("Henry copy:" + cloneHenry);
        System.out.println("change Henry's address");
        Address newAddress = henry.getAddress();
        newAddress.setCountry("USA");
        newAddress.setCity("San Francisco");
        System.out.println("Henry:" + henry);
        System.out.println("Henry copy:" + cloneHenry);
    }

    private static void testDeepCopy() throws CloneNotSupportedException {
        Address beijing = new Address();
        beijing.setCountry("China");
        beijing.setCity("beijing");
        DeepCopyUser henry = new DeepCopyUser();
        henry.setName("Henry");
        henry.setAge(30);
        henry.setAddress(beijing);
        DeepCopyUser cloneHenry = henry.clone();
        System.out.println("Henry:" + henry);
        System.out.println("Henry copy:" + cloneHenry);
        System.out.println("change Henry's address");
        Address newAddress = henry.getAddress();
        newAddress.setCountry("USA");
        newAddress.setCity("San Francisco");
        System.out.println("Henry:" + henry);
        System.out.println("Henry copy:" + cloneHenry);
    }
}
