package com.com.henryxi.core.util.compare;

public class ComparableUser implements Comparable<ComparableUser> {

    public ComparableUser(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    private String username;
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public int compareTo(ComparableUser o) {
        return this.age.compareTo(o.age);
    }

    @Override
    public String toString() {
        return "ComparableUser{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
