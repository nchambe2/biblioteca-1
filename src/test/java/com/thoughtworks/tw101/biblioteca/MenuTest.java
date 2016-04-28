package com.thoughtworks.tw101.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MenuTest {
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private BookCatalog bookCatalog;
    private Menu menu;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        bookCatalog = mock(BookCatalog.class);
        menu = new Menu(printStream, bufferedReader, bookCatalog);
    }

    @Test
    public void shouldPrintOptionsWhenMenuIsPrinted(){
        menu.printMenu();

        verify(printStream).println(contains("List Books"));
    }

    @Test
    public void shouldReturnOneWhenUserInputsOne() throws IOException {
        userWillSelectOptionOne();

        assertThat(menu.getUserInput(), is("1"));
    }

    @Test
    public void shouldPrintBookListWhenOptionOneIsSelected() {
        menu.runSelectedOption("1");

        verify(bookCatalog).listBooks();
    }

    private void userWillSelectOptionOne() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
    }
}