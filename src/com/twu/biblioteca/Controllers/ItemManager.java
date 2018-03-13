package com.twu.biblioteca.Controllers;

import com.twu.biblioteca.Models.Item;
import com.twu.biblioteca.Models.ItemType;
import com.twu.biblioteca.Repository.BookRepository;
import com.twu.biblioteca.Repository.ItemRepositoryInterface;
import com.twu.biblioteca.Repository.MovieRepository;
import com.twu.biblioteca.Utils.MessageContainer;

public class ItemManager {
    private BookRepository br;
    private MovieRepository mr;

    public ItemManager(BookRepository br, MovieRepository mr) {
        this.br = br;
        this.mr = mr;
    }

    public String getItemList(int type){
        if(type == ItemType.BOOK) return MessageContainer.getBookDetails(br.getItemList(), "Book details");
        return MessageContainer.getMovieDetails(mr.getItemList(), "Movie details");
    }

    public String getCheckedoutItemList(int type){
        if(type == ItemType.BOOK) return MessageContainer.getBookDetails(br.getCheckedoutItemList(), "Books to return");
        return MessageContainer.getMovieDetails(mr.getCheckedoutItemList(), "Movies to return");
    }

    public boolean checkoutItem(int type, int index){
        if(type == ItemType.BOOK) return doCheckout(this.br, index);
        return doCheckout(this.mr, index);
    }

    private boolean doCheckout (ItemRepositoryInterface rep, int index){
        if(index >= rep.getItemList().size()) return false;

        Item item = rep.getItemList().get(index);
        rep.removeItem(index);
        rep.addCheckedoutItem(item);
        return true;
    }

    public boolean returnItem(int type, int index){
        if(type == ItemType.BOOK) return doReturn(br, index);
        return doReturn(mr, index);
    }

    private boolean doReturn(ItemRepositoryInterface rep, int index){
        if(index >= rep.getCheckedoutItemList().size()) return false;

        Item item = rep.getCheckedoutItemList().get(index);
        rep.removeCheckedoutItem(index);
        rep.addItem(item);
        return true;
    }

    public boolean hasItemToReturn(int type){
        if(type == ItemType.BOOK) return (this.br.getCheckedoutItemList().size() > 0 ?  true : false);
        return this.mr.getCheckedoutItemList().size() > 0 ? true : false;
    }

    public boolean hasItemToCheckout(int type){
        if(type == ItemType.BOOK) return (this.br.getItemList().size() > 0 ?  true : false);
        return this.mr.getItemList().size() > 0 ? true : false;
    }

    public BookRepository getBookRepository() {
        return br;
    }

    public MovieRepository getMovieRepository() {
        return mr;
    }
}
