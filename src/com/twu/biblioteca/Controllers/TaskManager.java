package com.twu.biblioteca.Controllers;

import com.twu.biblioteca.Models.Book;
import com.twu.biblioteca.Utils.IOManager;
import com.twu.biblioteca.Utils.MessageContainer;

public class TaskManager extends BookManager{
    protected IOManager iom = new IOManager();

    protected void showBookList(){
        this.iom.printString(MessageContainer.getBookDetails(this.getBookList()));
    }

    protected void invalidOptionMessage(){
        this.iom.printString("\n::Error:: Select a valid option!");
    }

    protected boolean checkoutBook(int index){
        if(index >= getBookList().size()) return false;

        Book book = getBookList().get(index);
        removeBook(index);
        addCheckedoutBook(book);
        return true;
    }
}
