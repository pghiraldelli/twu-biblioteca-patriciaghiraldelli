package com.twu.biblioteca.Controllers;

import com.twu.biblioteca.Utils.IOManager;
import com.twu.biblioteca.Utils.MessageContainer;

public class ConsoleManager extends BookManager {
    private IOManager iom = new IOManager();

    public void mainMenu(){
        showWelcomeMessage();
        showBookList();
    }

    private void showWelcomeMessage(){
        this.iom.printString(MessageContainer.getWelcomeMessage());
    }

    private void showBookList(){
        this.iom.printString(MessageContainer.getBookList(this.getBookList()));
    }
}
