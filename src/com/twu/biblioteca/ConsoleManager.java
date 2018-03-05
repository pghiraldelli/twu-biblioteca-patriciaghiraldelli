package com.twu.biblioteca;

public class ConsoleManager {
    IOManager iom = new IOManager();

    public void mainMenu(){
        showWelcomeMessage();
    }

    private void showWelcomeMessage(){
        iom.printString(MessageContainer.getWelcomeMessage());
    }

}
