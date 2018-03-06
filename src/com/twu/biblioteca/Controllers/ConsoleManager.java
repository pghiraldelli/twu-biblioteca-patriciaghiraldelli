package com.twu.biblioteca.Controllers;

import com.twu.biblioteca.Utils.MessageContainer;

public class ConsoleManager extends TaskManager {
    private boolean runningTasks = true;

    public void mainMenu(){
        showWelcomeMessage();
        while(runningTasks){
            runningTasks = runMenu();
        }
    }

    private boolean runMenu(){
        showMenuOptions();
        int option = askForInt("Choose the menu option:");
        return runTask(option);
    }

    protected boolean runTask(int option){
        switch (option){
            case 0:
                return false;
            case 1:
                showBookList();
                break;
            case 2:
                runCheckout();
                break;
            case 3:
                runReturnBook();
                break;
            default:
                invalidOptionMessage();
        }
        return true;
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

    private void runCheckout(){
        this.iom.printString("\nEnter the number of the book to checkout: ");
        int index = this.iom.readInt();
        boolean success = checkoutBook(index);
        showFinalMessageToCheckout(success);
    }

    private void showFinalMessageToCheckout(boolean success){
        if(success) {
            this.iom.printString("\n::Success:: Thank you! Enjoy the book.\n");
            return;
        }
        this.iom.printString("\n::Error:: That book is not available\n");
    }

    private void runReturnBook(){
        if(getCheckedoutBookList().size() == 0){
            this.iom.printString("\n::Attention:: There are no books to return. Choose another option.");
            return;
        }

        showCheckedBookList();
        this.iom.printString("Enter the number of the book to return: ");
        int index = this.iom.readInt();
        boolean success = returnBook(index);
        showFinalMessageToReturn(success);
    }

    private void showFinalMessageToReturn(boolean success){
        if(success) {
            this.iom.printString("\n::Success:: Thank you for returning the book.\n");
            return;
        }
        this.iom.printString("\n::Error:: That is not a valid book to return.\n");
    }
}
