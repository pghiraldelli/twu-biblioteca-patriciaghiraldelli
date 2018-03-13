package com.twu.biblioteca.Repository;

import com.twu.biblioteca.Models.Item;
import com.twu.biblioteca.Models.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieRepository implements ItemRepositoryInterface {
    private List<Item> itemList;
    private List<Item> checkedoutItems;

    public MovieRepository() {
        this.itemList = createItemList();
        this.checkedoutItems = new ArrayList<Item>();
    }

    @Override
    public List<Item> createItemList() {
        List<Item> movies = new ArrayList<Item>();
        movies.add(createMovie("Movie 1", "2010", "Director 1", 3));
        movies.add(createMovie("Movie 2", "2018", "Director 2"));
        movies.add(createMovie("Movie 3", "1850", "Director 3", 5));
        movies.add(createMovie("Movie 4", "1900", "Director 4", 10));
        movies.add(createMovie("Movie 5", "2000", "Director 5", 7));
        return movies;
    }

    @Override
    public List<Item> getItemList() {
        return itemList;
    }

    @Override
    public void addItem(Item movie){
        itemList.add(movie);
    }

    @Override
    public void removeItem(int index){
        this.itemList.remove(index);
    }

    @Override
    public List<Item> getCheckedoutItemList(){
        return this.checkedoutItems;
    }

    @Override
    public void addCheckedoutItem(Item movie){
        this.checkedoutItems.add(movie);
    }

    @Override
    public void removeCheckedoutItem(int index){
        this.checkedoutItems.remove(index);
    }

    public Movie createMovie(String name, String year, String director, int rate){
        return new Movie(name, year, director, rate);
    }
}