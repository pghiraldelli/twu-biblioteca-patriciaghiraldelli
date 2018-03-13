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
        ioMan = new IOManager();
        BookRepository bookRepository = new BookRepository();
        MovieRepository movieRepository = new MovieRepository();
        taskMan = new TaskManager(bookRepository, movieRepository);
    }

    public void mainMenu(){
        showWelcomeMessage();
        while(runningTasks){
            runningTasks = runMenu();
        }
        showGoodbyeMessage();
    }

    private boolean runMenu(){
        showMenuOptions();
        int option = askForInt(MessageContainer.MSG_MENU_OPTION);
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
        this.ioMan.printString(MessageContainer.WELCOME_MESSAGE);
    }

    private void showBookList(){
        if(!taskMan.hasAvailableBooks()){
            this.ioMan.printString(MessageContainer.getNoAvaibleItemsMsg("books"));
            return;
        }

        this.ioMan.printString(taskMan.getBookList());
    }

    private void showMovieList(){
        if(!taskMan.hasAvailableMovies()){
            this.ioMan.printString(MessageContainer.getNoAvaibleItemsMsg("movies"));
            return;
        }

        this.ioMan.printString(taskMan.getMovieList());
    }

    private void runBookCheckout(){
        int index = askForInt(MessageContainer.getNumberItemMsg("book", "checkout"));
        boolean success = taskMan.checkoutBook(index);
        showFinalMessageToBookCheckout(success);
    }

    private void runMovieCheckout(){
        int index = askForInt(MessageContainer.getNumberItemMsg("movie", "checkout"));
        boolean success = taskMan.checkoutMovie(index);
        showFinalMessageToMovieCheckout(success);
    }

    private void runReturnBook(){
        if(!taskMan.hasBookToReturn()){
            this.ioMan.printString(MessageContainer.getNoItemsReturnMsg("books"));
            return;
        }

        this.ioMan.printString(taskMan.getCheckedBookList());
        int index = askForInt(MessageContainer.getNumberItemMsg("book", "return"));
        boolean success = taskMan.returnBook(index);
        showFinalMessageToReturn(success);
    }

    private void showFinalMessageToBookCheckout(boolean success){
        if(success) {
            this.ioMan.printString(MessageContainer.getSuccessEnjoyMsg("book"));
            return;
        }
        this.ioMan.printString(MessageContainer.getInvalidItemMsg("book", "checkout"));
    }

    private void showFinalMessageToMovieCheckout(boolean success){
        if(success) {
            this.ioMan.printString(MessageContainer.getSuccessEnjoyMsg("movie"));
            return;
        }
        this.ioMan.printString(MessageContainer.getInvalidItemMsg("movie", "checkout"));
    }

    private void showFinalMessageToReturn(boolean success){
        if(success) {
            this.ioMan.printString(MessageContainer.getSuccessReturnMsg("book"));
            return;
        }
        this.ioMan.printString(MessageContainer.getInvalidItemMsg("book","return"));
    }

    private void showInvalidOptionMessage(){
        this.ioMan.printString(MessageContainer.MSG_INVALID_OPTION);
    }

    private int askForInt(String text){
        this.ioMan.printString(text);
        return this.ioMan.readInt();
    }

    private void showGoodbyeMessage(){
        this.ioMan.printString(MessageContainer.GOODBYE_MESSAGE);
    }
}
