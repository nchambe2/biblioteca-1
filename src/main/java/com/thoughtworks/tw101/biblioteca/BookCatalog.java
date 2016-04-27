package com.thoughtworks.tw101.biblioteca;

import java.io.PrintStream;
import java.util.List;

/**
 * Created by toby on 4/26/16.
 */
public class BookCatalog {
    private List<String> bookList;
    private PrintStream printStream;

    public BookCatalog(List<String> bookList, PrintStream printStream) {
        this.bookList = bookList;
        this.printStream = printStream;
    }


    public void listBooks() {
        for(String curBook : bookList) {
            printStream.println(curBook);
        }
    }
}
