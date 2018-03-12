package com.twu.biblioteca.Models;

public class Item {
    private int type;
    protected String name;
    protected String year;
    protected String responsible;
    protected int status;

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
