package com.henryxi.java.core.collection.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestGroupBy {
    private String username;
    private String auditeCategory;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestGroupBy that = (TestGroupBy) o;

        if (username != null ? !username.equals(that.username) : that.username != null)
            return false;
        return auditeCategory != null ? auditeCategory.equals(that.auditeCategory) : that.auditeCategory == null;

    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (auditeCategory != null ? auditeCategory.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("1", "1", 1));
        userList.add(new User("2", "1", 2));
        userList.add(new User("3", "2", 2));
        userList.add(new User("4", "3", 2));
        userList.add(new User("5", "4", 5));
        Map<String, Map<Integer, List<User>>> collect = userList.stream().collect(Collectors.groupingBy(User::getCity, Collectors.groupingBy(User::getAge)));
        System.out.println(collect);
//        System.out.println(collect);
// userList.stream().count()
    }
}
