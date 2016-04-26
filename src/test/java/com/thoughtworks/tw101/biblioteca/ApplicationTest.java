package com.thoughtworks.tw101.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.fail;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class ApplicationTest {


    private PrintStream printStream;
    private Application application;

    @Before
    public void setup(){
        printStream = mock(PrintStream.class);
        application = new Application(printStream);
    }

    @Test
    public void shouldWelcomeUserWhenApplicationStarts() {
        application.start();
        verify(printStream).println(contains("Welcome"));
    }

    @Test
    public void shouldPrintAllBookTitlesWhenMoreThanOneBookInLibrary() {

        application.addBook("book 1");
        application.addBook("book 2");
        application.start();

        verify(printStream).println(contains("book 1"));
        verify(printStream).println(contains("book 2"));
    }

    @Test
    public void shouldPrintNothingWhenLibraryIsEmpty() {
        application.listBooks();

        verifyNoMoreInteractions(printStream);
    }
}