package com.twu.biblioteca.Controllers;

public class ConsoleManager extends Manager {
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
