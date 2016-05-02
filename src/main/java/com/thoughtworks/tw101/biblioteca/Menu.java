package com.thoughtworks.tw101.biblioteca;

import java.io.PrintStream;

import static java.lang.Integer.parseInt;

public class Menu {

    public static final String OPTION_LIST_BOOKS = "1";
    public static final String OPTION_CHECKOUT_BOOKS = "2";
    private PrintStream printStream;
    private BookCatalog bookCatalog;
    private MenuPrompter prompter;

    public Menu(PrintStream printStream, BookCatalog bookCatalog, MenuPrompter prompter) {

        this.printStream = printStream;
        this.bookCatalog = bookCatalog;
        this.prompter = prompter;
    }

    public void printMenu() {
        printStream.println("Select Option:");
        printStream.println("0. Quit");
        printStream.println("1. List Books");
        printStream.println("2. Checkout Book");
    }


    public void runSelectedOption(String userInput) {

        if(userInput.equals(OPTION_LIST_BOOKS)) {
            bookCatalog.listBooks();
        }

        if(userInput.equals(OPTION_CHECKOUT_BOOKS)){
            bookCatalog.listBooks();
            int checkoutChoice = parseInt(prompter.promptUserForInput());
            bookCatalog.checkOut(checkoutChoice);
        }


    }


}
