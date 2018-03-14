package com.twu.biblioteca.Models;

public class User {
    private String number;
    private String password;
    private int type;

    public User(String number, String password, int type){
        this.number = number;
        this.password = password;
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public String getPassword() {
        return password;
    }

    public int getType() {
        return type;
    }
}
