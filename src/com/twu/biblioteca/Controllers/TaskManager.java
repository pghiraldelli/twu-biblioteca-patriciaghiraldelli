package com.twu.biblioteca.Controllers;

import com.twu.biblioteca.Models.ItemType;
import com.twu.biblioteca.Repository.BookRepository;
import com.twu.biblioteca.Repository.MovieRepository;

public class TaskManager{
    private ItemManager itemManager;

    public TaskManager(BookRepository br, MovieRepository mr) {
        this.itemManager = new ItemManager(br,mr);
    }

    public String getBookList(){
        return itemManager.getItemList(ItemType.BOOK);
    }

    public String getMovieList(){
        return itemManager.getItemList(ItemType.MOVIE);
    }

    public String getCheckedBookList(){
        return itemManager.getCheckedoutItemList(ItemType.BOOK);
    }

    public String getCheckedMovieList(){
        return itemManager.getCheckedoutItemList(ItemType.MOVIE);
    }

    public boolean checkoutBook(int index){
        return itemManager.checkoutItem(ItemType.BOOK, index);
    }

    public boolean checkoutMovie(int index){
        return itemManager.checkoutItem(ItemType.MOVIE, index);
    }

    public boolean returnBook(int index){
        return itemManager.returnItem(ItemType.BOOK, index);
    }

    public boolean returnMovie(int index){
        return itemManager.returnItem(ItemType.MOVIE, index);
    }

    public boolean hasBookToReturn(){
        return itemManager.hasItemToReturn(ItemType.BOOK);
    }

    public boolean hasMovieToReturn(){
        return itemManager.hasItemToReturn(ItemType.MOVIE);
    }

    public boolean hasAvailableBooks(){
        return itemManager.hasItemToCheckout(ItemType.BOOK);
    }

    public boolean hasAvailableMovies(){
        return itemManager.hasItemToCheckout(ItemType.MOVIE);
    }

}
