package com.twu.biblioteca.Models;

import java.util.Objects;

public class Movie extends Item{
    private int rate = 0;

    public Movie(String name, String year, String director, int rate) {
        this.setType(ItemType.MOVIE);
        this.setStatus(0);
        this.name = name;
        this.year = year;
        this.responsible = director;
        this.rate = rate;

    }

    public Movie(String name, String year, String director) {
        this.setType(ItemType.MOVIE);
        this.name = name;
        this.year = year;
        this.responsible = director;
    }


    public String getName() {
        return super.getName();
    }

    public String getYear() {
        return super.getYear();
    }

    public String getDirector() {
        return super.getResponsible();
    }

    public int getRate() {
        return rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return rate == movie.rate &&
                Objects.equals(getName(), movie.getName()) &&
                Objects.equals(this.getYear(), movie.getYear()) &&
                Objects.equals(this.getDirector(), movie.getDirector());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getYear(), getDirector(), rate);
    }
}
