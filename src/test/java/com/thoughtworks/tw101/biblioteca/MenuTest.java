package com.thoughtworks.tw101.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class MenuTest {
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private BookCatalog bookCatalog;
    private Menu menu;
    private MenuPrompter menuPrompter;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        bookCatalog = mock(BookCatalog.class);
        menuPrompter = mock(MenuPrompter.class);
        menu = new Menu(printStream, bookCatalog, menuPrompter);
    }

    @Test
    public void shouldPrintOptionsWhenMenuIsPrinted(){
        menu.printMenu();

        verify(printStream).println(contains("List Books"));
    }

    @Test
    public void shouldPrintBookListWhenOptionOneIsSelected() throws IOException {
        userWillSelectOptionOne();
        menu.runSelectedOption("1");

        verify(bookCatalog).listBooks();
    }

    @Test
    public void shouldIncludeCheckOutAsMenuOption() {
        menu.printMenu();

        verify(printStream).println(contains("Checkout Book"));
    }




    private void userWillSelectOptionTwo() throws IOException {
        when(bufferedReader.readLine()).thenReturn("2");
    }

    private void userWillSelectOptionOne() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
    }


}