package com.henryxi.java.core.lang.constructor;

public class Products {
    private String product_id;
    private String store;

    public Products(String product_id, String store) {
        super();
        this.product_id = product_id;
        this.store = store;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    @Override
    public String toString() {
        return "Products{" +
                "product_id='" + product_id + '\'' +
                ", store='" + store + '\'' +
                '}';
    }
}