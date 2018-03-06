package com.twu.biblioteca.Controllers;

import com.twu.biblioteca.Utils.IOManager;
import com.twu.biblioteca.Utils.MessageContainer;

public class TaskManager extends BookManager{
    protected IOManager iom = new IOManager();

    //How to test this kind of method?
    protected void runTask(int option){
        switch (option){
            case 1:
                showBookList();
                break;
            default:
                invalidOptionMessage();
        }
    }

    private void showBookList(){
        this.iom.printString(MessageContainer.getBookList(this.getBookList()));
    }

    private void invalidOptionMessage(){
        this.iom.printString("\n::Error:: Select a valid option!");
    }
}
