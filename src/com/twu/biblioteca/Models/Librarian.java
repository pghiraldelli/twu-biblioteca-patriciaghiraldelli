package com.twu.biblioteca.Models;

public class Librarian extends User {

    public Librarian(String number, String password) {
        super(number, password, UserType.LIBRARIAN);
    }
}
