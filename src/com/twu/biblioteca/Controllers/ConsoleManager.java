package com.twu.biblioteca.Controllers;

import com.twu.biblioteca.Utils.MessageContainer;

public class ConsoleManager extends TaskManager {


    public void mainMenu(){
        showWelcomeMessage();
        runMenu();
    }

    private void runMenu(){
        showMenuOptions();
        int option = askForInt("Escolha a opção do menu:");
        runTask(option);
    }

    private int askForInt(String text){
        System.out.println(text);
        return this.iom.readInt();
    }

    private void showMenuOptions(){
        this.iom.printString(MessageContainer.getMenuOptions());
    }

    private void showWelcomeMessage(){
        this.iom.printString(MessageContainer.getWelcomeMessage());
    }
}
