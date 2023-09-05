package com.henryxi.java.core.lang.constructor;

import java.util.List;

public class TokenData {
    private String Token;
    List<Products> products;

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    public TokenData(String token, List<Products> products) {
        super();
        Token = token;
        this.products = products;
    }

    @Override
    public String toString() {
        return "TokenData{" +
                "Token='" + Token + '\'' +
                ", products=" + products +
                '}';
    }
}