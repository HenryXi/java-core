package com.henryxi.java.core.collection.list;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class ArrayListAdd {
    private static final Field field;

    static {
        try {
            field = ArrayList.class.getDeclaredField("elementData");
            field.setAccessible(true);
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    @SuppressWarnings("unchecked")
    private static <E> void printLengthOfElementDate(ArrayList<E> arrayList) {
        try {
            final E[] elementData = (E[]) field.get(arrayList);
            E e = arrayList.get(arrayList.size() - 1);
            System.out.println("after add '" + e + "' elementData length of List:" + elementData.length);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("luck1");
        printLengthOfElementDate(stringList);
        stringList.add("luck2");
        printLengthOfElementDate(stringList);
        stringList.add("luck3");
        printLengthOfElementDate(stringList);
        stringList.add("luck4");
        printLengthOfElementDate(stringList);
        stringList.add("luck5");
        printLengthOfElementDate(stringList);
        stringList.add("luck6");
        printLengthOfElementDate(stringList);
        stringList.add("luck7");
        printLengthOfElementDate(stringList);
        stringList.add("luck8");
        printLengthOfElementDate(stringList);
        stringList.add("luck9");
        printLengthOfElementDate(stringList);
        stringList.add("luck10");
        printLengthOfElementDate(stringList);
        stringList.add("luck11");
        printLengthOfElementDate(stringList);
        stringList.add("luck12");
        printLengthOfElementDate(stringList);
        stringList.add("luck13");
        printLengthOfElementDate(stringList);
        stringList.add("luck14");
        printLengthOfElementDate(stringList);
        stringList.add("luck15");
        printLengthOfElementDate(stringList);
        stringList.add("luck16");
        printLengthOfElementDate(stringList);
        stringList.add("luck17");
        printLengthOfElementDate(stringList);
    }
}
