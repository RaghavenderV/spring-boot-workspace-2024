package com.vodapally.postconstuct_demo.entity;

public class Customer {
    private String name;
    private String location;

    public Customer(String name, String location) {
        this.name = name;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
