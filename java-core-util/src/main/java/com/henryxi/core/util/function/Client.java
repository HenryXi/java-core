package com.henryxi.core.util.function;

public class Client {
    public static void main(String[] args) {
        User user = new User(1, "henryxi");
        WrapperUser wrapperUser = new WrapperUser();
        Convert.convert(wrapperUser::setId, user, User::getId);
        System.out.println(wrapperUser);
    }
}
