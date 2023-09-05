package com.henryxi.core.util.optional;

import java.io.Serializable;

public class Address implements Serializable{
    private static final long serialVersionUID = 7693773278190111789L;
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
