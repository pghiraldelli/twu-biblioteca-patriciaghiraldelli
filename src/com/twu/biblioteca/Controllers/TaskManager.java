package com.twu.biblioteca.Controllers;

import com.twu.biblioteca.Models.Book;
import com.twu.biblioteca.Repository.BookRepository;
import com.twu.biblioteca.Utils.IOManager;
import com.twu.biblioteca.Utils.MessageContainer;

public class TaskManager{
    private IOManager iom;
    private BookRepository bs;

    public TaskManager(IOManager iom, BookRepository bs) {
        this.iom = iom;
        this.bs = bs;
    }

    protected void showBookList(){
        this.iom.printString(MessageContainer.getBookDetails(bs.getBookList(), "Book details"));
    }

    protected void showCheckedBookList(){
        this.iom.printString(MessageContainer.getBookDetails(bs.getCheckedoutBookList(), "Books to return"));
    }

    protected void invalidOptionMessage(){
        this.iom.printString("\n::Error:: Select a valid option!");
    }

    protected boolean checkoutBook(int index){
        if(index >= bs.getBookList().size()) return false;

        Book book = bs.getBookList().get(index);
        bs.removeBook(index);
        bs.addCheckedoutBook(book);
        return true;
    }

    protected boolean returnBook(int index){
        if(index >= bs.getCheckedoutBookList().size()) return false;

        Book book = bs.getCheckedoutBookList().get(index);
        bs.removeCheckedoutBook(index);
        bs.addBook(book);
        return true;
    }

    public IOManager getIOManager() {
        return iom;
    }

    public BookRepository getBookService() {
        return bs;
    }
}
