package com.twu.biblioteca.Repository;

import com.twu.biblioteca.Models.Book;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private List<Book> bookList;
    private List<Book> checkedOutBooks;

    public BookRepository(){
        this.bookList = createBookList();
        this.checkedOutBooks = new ArrayList<Book>();
    }

    public List<Book> getBookList(){
        return this.bookList;
    }

    public List<Book> getCheckedoutBookList(){
        return this.checkedOutBooks;
    }

    private List<Book> createBookList(){
        List<Book> books = new ArrayList<Book>();
        books.add(createBook("Book 1", "Author 1", "1994"));
        books.add(createBook("Book 2", "Author 2", "2018"));
        books.add(createBook("Book 3", "Author 3", "2000"));
        return books;
    }

    private Book createBook(String title, String author, String year){
        return new Book(title, author, year);
    }

    public void removeBook(int index){
        this.bookList.remove(index);
    }

    public void addBook(Book book){
        this.bookList.add(book);
    }

    public void addCheckedoutBook(Book book){
        this.checkedOutBooks.add(book);
    }

    public void removeCheckedoutBook(int index){
        this.checkedOutBooks.remove(index);
    }
}
