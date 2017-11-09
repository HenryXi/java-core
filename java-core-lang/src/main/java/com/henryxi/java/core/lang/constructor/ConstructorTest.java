package com.henryxi.java.core.lang.constructor;

import java.util.ArrayList;
import java.util.List;

public class ConstructorTest {
    public static void main(String[] args) {
        Products products = new Products("product_id", "store");
        List<Products> list = new ArrayList<>();
        list.add(products);
        TokenData tokenData = new TokenData("token", list);
        System.out.println(tokenData);
    }
}
