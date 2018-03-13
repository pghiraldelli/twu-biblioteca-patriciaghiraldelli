package com.twu.biblioteca.Controllers;

import com.twu.biblioteca.Models.Task;
import com.twu.biblioteca.Repository.BookRepository;
import com.twu.biblioteca.Repository.MovieRepository;
import com.twu.biblioteca.Utils.IOManager;
import com.twu.biblioteca.Utils.MessageContainer;

public class ConsoleManager {
    private boolean runningTasks = true;
    private TaskManager taskMan;
    private IOManager ioMan;

    public ConsoleManager() {
        BookRepository bookRepository = new BookRepository();
        ioMan = new IOManager();
        MovieRepository movieRepository = new MovieRepository();
        taskMan = new TaskManager(bookRepository, movieRepository);
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
                showBookList();
                break;
            case Task.CHECKOUTBOOK:
                runBookCheckout();
                break;
            case Task.RETURNBOOK:
                runReturnBook();
                break;
            case Task.MOVIEDETAILS:
                showMovieList();
                break;
            default:
                showInvalidOptionMessage();
        }
        return true;
    }

    private void showMenuOptions(){
        this.ioMan.printString(MessageContainer.getMenuOptions());
    }

    private void showWelcomeMessage(){
        this.ioMan.printString(MessageContainer.getWelcomeMessage());
    }

    private void showBookList(){
        if(!taskMan.hasAvailableBooks()){
            this.ioMan.printString("\n::Attention:: There are no available books. Choose another option.");
            return;
        }

        this.ioMan.printString(taskMan.getBookList());
    }

    private void showMovieList(){
        if(!taskMan.hasAvailableMovies()){
            this.ioMan.printString("\n::Attention:: There are no available movies. Choose another option.");
            return;
        }

        this.ioMan.printString(taskMan.getMovieList());
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

    private void runReturnBook(){
        if(!taskMan.hasBookToReturn()){
            this.ioMan.printString("\n::Attention:: There are no books to return. Choose another option.");
            return;
        }

        this.ioMan.printString(taskMan.getCheckedBookList());
        int index = askForInt("Enter the number of the book to return: ");
        boolean success = taskMan.returnBook(index);
        showFinalMessageToReturn(success);
    }

    private void showFinalMessageToBookCheckout(boolean success){
        if(success) {
            this.ioMan.printString("\n::Success:: Thank you! Enjoy the book.\n");
            return;
        }
        this.ioMan.printString("\n::Error:: That book is not available\n");
    }

    private void showFinalMessageToMovieCheckout(boolean success){
        if(success) {
            this.ioMan.printString("\n::Success:: Thank you! Enjoy the movie.\n");
            return;
        }
        this.ioMan.printString("\n::Error:: That movie is not available\n");
    }

    private void showFinalMessageToReturn(boolean success){
        if(success) {
            this.ioMan.printString("\n::Success:: Thank you for returning the book.\n");
            return;
        }
        this.ioMan.printString("\n::Error:: That is not a valid book to return.\n");
    }

    private void showInvalidOptionMessage(){
        this.ioMan.printString("\n::Error:: Select a valid option!");
    }

    private int askForInt(String text){
        this.ioMan.printString(text);
        return this.ioMan.readInt();
    }
}
