package com.twu.biblioteca.Models;

public class Customer extends User {
    private String name;
    private String email;
    private String telephone;

    public Customer(String number, String password, String name, String email, String telephone) {
        super(number, password, UserType.CUSTOMER);
        this.name = name;
        this.email = email;
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }
}
