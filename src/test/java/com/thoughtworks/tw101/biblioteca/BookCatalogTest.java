package com.thoughtworks.tw101.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.contains;
import static org.mockito.Matchers.matches;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * Created by toby on 4/26/16.
 */
public class BookCatalogTest {
    private PrintStream printStream;
    private List<String> bookList;
    private BookCatalog bookCatalog;

    @Before
    public void setup(){
        bookList = new ArrayList<>();
        printStream = mock(PrintStream.class);
        bookCatalog = new BookCatalog(bookList, printStream);
    }

    @Test
    public void shouldPrintAllBookTitlesWhenMoreThanOneBookInLibrary() {

        bookList.add("book 1");
        bookList.add("book 2");
        bookCatalog.listBooks();

        verify(printStream).println(contains("book 1"));
        verify(printStream).println(contains("book 2"));
    }

    @Test
    public void shouldPrintNoBooksWhenLibraryIsEmpty(){

        bookCatalog.listBooks();
        verifyNoMoreInteractions(printStream);
    }


    @Test
    public void shouldPrintAuthorColumn(){
        bookCatalog.listBooks();
        verify(printStream).println(contains("Author"));
    }

    @Test
    public void shouldPrintYearPublishedColumn(){
        bookCatalog.listBooks();
        verify(printStream).println(contains("Year Published"));
    }


}