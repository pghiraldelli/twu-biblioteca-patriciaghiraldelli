package com.twu.biblioteca.Controllers;

import com.twu.biblioteca.Models.Task;
import com.twu.biblioteca.Repository.BookService;
import com.twu.biblioteca.Utils.IOManager;
import com.twu.biblioteca.Utils.MessageContainer;

public class ConsoleManager {
    private boolean runningTasks = true;
    private TaskManager taskMan;

    public ConsoleManager() {
        BookService bookService = new BookService();
        IOManager ioMan = new IOManager();
        taskMan = new TaskManager(ioMan, bookService);
    }

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
            case Task.QUIT:
                return false;
            case Task.BOOKDETAILS:
                taskMan.showBookList();
                break;
            case Task.CHECKOUT:
                runCheckout();
                break;
            case Task.RETURN:
                runReturnBook();
                break;
            default:
                taskMan.invalidOptionMessage();
        }
        return true;
    }

    private int askForInt(String text){
        System.out.println(text);
        return taskMan.getIOManager().readInt();
    }

    private void showMenuOptions(){
        taskMan.getIOManager().printString(MessageContainer.getMenuOptions());
    }

    private void showWelcomeMessage(){
        taskMan.getIOManager().printString(MessageContainer.getWelcomeMessage());
    }

    private void runCheckout(){
        taskMan.getIOManager().printString("\nEnter the number of the book to checkout: ");
        int index = taskMan.getIOManager().readInt();
        boolean success = taskMan.checkoutBook(index);
        showFinalMessageToCheckout(success);
    }

    private void showFinalMessageToCheckout(boolean success){
        if(success) {
            taskMan.getIOManager().printString("\n::Success:: Thank you! Enjoy the book.\n");
            return;
        }
        taskMan.getIOManager().printString("\n::Error:: That book is not available\n");
    }

    private void runReturnBook(){
        if(taskMan.getBookService().getCheckedoutBookList().size() == 0){
            taskMan.getIOManager().printString("\n::Attention:: There are no books to return. Choose another option.");
            return;
        }

        taskMan.showCheckedBookList();
        taskMan.getIOManager().printString("Enter the number of the book to return: ");
        int index = taskMan.getIOManager().readInt();
        boolean success = taskMan.returnBook(index);
        showFinalMessageToReturn(success);
    }

    private void showFinalMessageToReturn(boolean success){
        if(success) {
            taskMan.getIOManager().printString("\n::Success:: Thank you for returning the book.\n");
            return;
        }
        taskMan.getIOManager().printString("\n::Error:: That is not a valid book to return.\n");
    }
}
