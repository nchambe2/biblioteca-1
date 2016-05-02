package com.thoughtworks.tw101.biblioteca;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.Integer.*;

/**
 * Created by toby on 4/26/16.
 */
public class BookCatalog {
    private List<Book> bookList;
    private PrintStream printStream;
    private Set<Book> checkedOutBooks;

    public BookCatalog(List<Book> bookList, PrintStream printStream) {
        this.bookList = bookList;
        this.printStream = printStream;
        this.checkedOutBooks = new HashSet<>();
    }


    public void listBooks() {
        String header = String.format("%1s|%2$-15s |%3$-15s |%4$-15s", "id", "Title", "Author", "Year Published");

        printStream.println(header);
        for (int id = 0; id < bookList.size(); id++) {
            Book curBook = bookList.get(id);
            String idString = Integer.toString(id);
            if (!isCheckedOut(curBook))
                printStream.println(id + curBook.details());
        }
    }


    private boolean isCheckedOut(Book curBook) {
        return checkedOutBooks.contains(curBook);
    }


    public void checkOut(int bookchoice) {
        Book bookToBeCheckOut = bookList.get(bookchoice);
        checkedOutBooks.add(bookToBeCheckOut);
    }
}
