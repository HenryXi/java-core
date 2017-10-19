package com.henryxi.core.util.optional;

import java.io.Serializable;
import java.util.Optional;

public class User implements Serializable {
    private static final long serialVersionUID = 3963394815847306665L;
    private String name;
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Optional<Address> getAddress() {
        return Optional.of(address);
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
