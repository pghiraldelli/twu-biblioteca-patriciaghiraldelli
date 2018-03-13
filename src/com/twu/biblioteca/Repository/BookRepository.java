package com.twu.biblioteca.Repository;

import com.twu.biblioteca.Models.Book;
import com.twu.biblioteca.Models.Item;

import java.util.ArrayList;
import java.util.List;

public class BookRepository implements ItemRepositoryInterface {
    private List<Item> bookList;
    private List<Item> checkedOutBooks;

    public BookRepository(){
        this.bookList = createItemList();
        this.checkedOutBooks = new ArrayList<Item>();
    }

    @Override
    public List<Item> createItemList(){
        List<Item> books = new ArrayList<Item>();
        books.add(createBook("Book 1", "Author 1", "1994"));
        books.add(createBook("Book 2", "Author 2", "2018"));
        books.add(createBook("Book 3", "Author 3", "2000"));
        return books;
    }

    @Override
    public List<Item> getItemList(){
        return this.bookList;
    }

    @Override
    public void addItem(Item book){
        this.bookList.add(book);
    }

    @Override
    public void removeItem(int index){
        this.bookList.remove(index);
    }

    @Override
    public List<Item> getCheckedoutItemList(){
        return this.checkedOutBooks;
    }

    @Override
    public void addCheckedoutItem(Item book){
        this.checkedOutBooks.add(book);
    }

    @Override
    public void removeCheckedoutItem(int index){
        this.checkedOutBooks.remove(index);
    }

    private Book createBook(String title, String author, String year){
        return new Book(title, author, year);
    }
}
