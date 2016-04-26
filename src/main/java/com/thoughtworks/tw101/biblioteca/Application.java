package com.thoughtworks.tw101.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;

public class Application {

    private ArrayList<String> books = new ArrayList<>();

    private PrintStream printStream;

    public Application(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void start() {
        printWelcomeMessage();
        listBooks();
    }

    private void printWelcomeMessage() {
        printStream.println("Welcome");
    }

    public void addBook(String book) {
        this.books.add(book);
    }

    public void listBooks() {
        for(String curBook : books) {
            printStream.println(curBook);
        }
    }
}
