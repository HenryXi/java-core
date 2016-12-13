package com.com.henryxi.core.util.compare;

import java.util.Comparator;

public class ComparatorByAge implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        int age1 = o1.getAge();
        int age2 = o2.getAge();
        return (age1 < age2) ? -1 : ((age1 == age2) ? 0 : 1);
    }
}
