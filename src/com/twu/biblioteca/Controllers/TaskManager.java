package com.twu.biblioteca.Controllers;

import com.twu.biblioteca.Models.Book;
import com.twu.biblioteca.Repository.BookRepository;
import com.twu.biblioteca.Repository.MovieRepository;
import com.twu.biblioteca.Utils.IOManager;
import com.twu.biblioteca.Utils.MessageContainer;

public class TaskManager{
    private IOManager iom;
    private BookRepository br;
    private MovieRepository mr;

    public TaskManager(IOManager iom, BookRepository br, MovieRepository mr) {
        this.iom = iom;
        this.br = br;
        this.mr = mr;
    }

    protected void showBookList(){
        this.iom.printString(MessageContainer.getBookDetails(br.getBookList(), "Book details"));
    }

    protected void showCheckedBookList(){
        this.iom.printString(MessageContainer.getBookDetails(br.getCheckedoutBookList(), "Books to return"));
    }

    protected void showMovieList(){
        this.iom.printString(MessageContainer.getMovieDetails(mr.getMovieList(), "Movie details"));
    }

    protected void invalidOptionMessage(){
        this.iom.printString("\n::Error:: Select a valid option!");
    }

    protected boolean checkoutBook(int index){
        if(index >= br.getBookList().size()) return false;

        Book book = br.getBookList().get(index);
        br.removeBook(index);
        br.addCheckedoutBook(book);
        return true;
    }

    protected boolean returnBook(int index){
        if(index >= br.getCheckedoutBookList().size()) return false;

        Book book = br.getCheckedoutBookList().get(index);
        br.removeCheckedoutBook(index);
        br.addBook(book);
        return true;
    }

    public IOManager getIOManager() {
        return iom;
    }

    public BookRepository getBookService() {
        return br;
    }
}
