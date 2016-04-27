package com.thoughtworks.tw101.biblioteca;

import java.io.PrintStream;
import java.util.List;

public class Biblioteca {

    private BookCatalog bookCatalog;
    private PrintStream printStream;

    public Biblioteca(PrintStream printStream, List<Book> bookList) {
        this.printStream = printStream;
        this.bookCatalog = new BookCatalog(bookList, printStream);
    }

    public void start() {
        printWelcomeMessage();
        bookCatalog.listBooks();
    }

    private void printWelcomeMessage() {
        printStream.println("Welcome");
    }

}
