package com.twu.biblioteca.Models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String number;
    private String password;
    private int type;
    private List<Reservation> reservationList;

    public User(String number, String password, int type){
        this.number = number;
        this.password = password;
        this.type = type;
        this.reservationList = new ArrayList<Reservation>();
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

    public List<Reservation> getReservationList() {
        return reservationList;
    }
}
