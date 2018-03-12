package com.twu.biblioteca.Controllers;

import com.twu.biblioteca.Models.Task;
import com.twu.biblioteca.Repository.BookRepository;
import com.twu.biblioteca.Repository.MovieRepository;
import com.twu.biblioteca.Utils.IOManager;
import com.twu.biblioteca.Utils.MessageContainer;

public class ConsoleManager {
    private boolean runningTasks = true;
    private TaskManager taskMan;

    public ConsoleManager() {
        BookRepository bookRepository = new BookRepository();
        IOManager ioMan = new IOManager();
        MovieRepository movieRepository = new MovieRepository();
        taskMan = new TaskManager(ioMan, bookRepository, movieRepository);
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
            case Task.CHECKOUTBOOK:
                runBookCheckout();
                break;
            case Task.RETURNBOOK:
                runReturnBook();
                break;
            case Task.MOVIEDETAILS:
                taskMan.showMovieList();
                break;
            default:
                taskMan.invalidOptionMessage();
        }
        return true;
    }

    private int askForInt(String text){
        taskMan.getIOManager().printString(text);
        return taskMan.getIOManager().readInt();
    }

    private void showMenuOptions(){
        taskMan.getIOManager().printString(MessageContainer.getMenuOptions());
    }

    private void showWelcomeMessage(){
        taskMan.getIOManager().printString(MessageContainer.getWelcomeMessage());
    }

    private void runBookCheckout(){
        int index = askForInt("\nEnter the number of the book to checkout: ");
        boolean success = taskMan.checkoutBook(index);
        showFinalMessageToBookCheckout(success);
    }

    private void runMovieCheckout(){
        int index = askForInt("\nEnter the number of the movie to checkout: ");
        boolean success = taskMan.checkoutMovie(index);
        showFinalMessageToMovieCheckout(success);
    }

    private void showFinalMessageToBookCheckout(boolean success){
        if(success) {
            taskMan.getIOManager().printString("\n::Success:: Thank you! Enjoy the book.\n");
            return;
        }
        taskMan.getIOManager().printString("\n::Error:: That book is not available\n");
    }

    private void showFinalMessageToMovieCheckout(boolean success){
        if(success) {
            taskMan.getIOManager().printString("\n::Success:: Thank you! Enjoy the movie.\n");
            return;
        }
        taskMan.getIOManager().printString("\n::Error:: That movie is not available\n");
    }

    private void runReturnBook(){
        if(taskMan.getBookRepository().getCheckedoutBookList().size() == 0){
            taskMan.getIOManager().printString("\n::Attention:: There are no books to return. Choose another option.");
            return;
        }

        taskMan.showCheckedBookList();
        int index = askForInt("Enter the number of the book to return: ");
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
