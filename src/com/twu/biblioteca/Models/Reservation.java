package com.twu.biblioteca.Models;

public class Reservation {
    private Item item;
    private User user;

    public Reservation(Item item, User user) {
        this.item = item;
        this.user = user;
    }

    public Item getItem() {
        return item;
    }

    public User getUser() {
        return user;
    }
}
