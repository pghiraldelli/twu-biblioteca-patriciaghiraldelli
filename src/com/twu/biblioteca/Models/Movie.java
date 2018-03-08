package com.twu.biblioteca.Models;

import java.util.Objects;

public class Movie {
    private String name;
    private String year;
    private String director;
    private int rate;

    public Movie(String name, String year, String director, int rate) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rate = rate;
    }


    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getDirector() {
        return director;
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
                Objects.equals(name, movie.name) &&
                Objects.equals(year, movie.year) &&
                Objects.equals(director, movie.director);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year, director, rate);
    }
}
