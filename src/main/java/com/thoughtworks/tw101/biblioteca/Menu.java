package com.thoughtworks.tw101.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Menu {

    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private BookCatalog bookCatalog;

    public Menu(PrintStream printStream, BufferedReader bufferedReader, BookCatalog bookCatalog) {

        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.bookCatalog = bookCatalog;
    }

    public void printMenu() {
        printStream.println("Select Option:");
        printStream.println("1. List Books");
    }

    public String getUserInput() {
        String userInput = getBufferedReaderInput();
        return userInput;
    }

    private String getBufferedReaderInput() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void runSelectedOption(String selectedOption) {
        if (selectedOption.equals("1")) {
            bookCatalog.listBooks();
        }
    }

    public void testingMethod(String something) {
        return ;
    }

}
