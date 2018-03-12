package com.twu.biblioteca.Repository;

import com.twu.biblioteca.Models.Item;
import com.twu.biblioteca.Models.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieRepository extends ItemRepository{
    public MovieRepository() {
        this.itemList = createMovieList();
        this.checkedoutItems = new ArrayList<Item>();
    }

    public List<Item> createMovieList(){
        List<Item> movies = new ArrayList<Item>();
        movies.add(createMovie("Movie 1", "2010", "Director 1", 3));
        movies.add(createMovie("Movie 2", "2018", "Director 2"));
        movies.add(createMovie("Movie 3", "1850", "Director 3", 5));
        movies.add(createMovie("Movie 4", "1900", "Director 4", 10));
        movies.add(createMovie("Movie 5", "2000", "Director 5", 7));
        return movies;
    }

    public Movie createMovie(String name, String year, String director, int rate){
        return new Movie(name, year, director, rate);
    }

    public Movie createMovie(String name, String year, String director){
        return new Movie(name, year, director);
    }

    public void addCheckedoutMovie(Movie movie){
        this.checkedoutItems.add(movie);
    }

    public void removeMovie(int index){
        this.itemList.remove(index);
    }

    public List<Item> getMovieList() {
        return itemList;
    }
}