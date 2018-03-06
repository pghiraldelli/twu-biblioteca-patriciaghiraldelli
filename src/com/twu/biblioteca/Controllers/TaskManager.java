package com.twu.biblioteca.Controllers;

import com.twu.biblioteca.Utils.IOManager;
import com.twu.biblioteca.Utils.MessageContainer;

public class TaskManager extends BookManager{
    protected IOManager iom = new IOManager();

    protected boolean runTask(int option){
        switch (option){
            case 0:
                return false;
            case 1:
                showBookList();
                break;
            default:
                invalidOptionMessage();
        }
        return true;
    }

    private void showBookList(){
        this.iom.printString(MessageContainer.getBookDetails(this.getBookList()));
    }

    private void invalidOptionMessage(){
        this.iom.printString("\n::Error:: Select a valid option!");
    }
}
