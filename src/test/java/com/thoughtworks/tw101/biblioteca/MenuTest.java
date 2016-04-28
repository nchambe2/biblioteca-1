package com.thoughtworks.tw101.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

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
    public void shouldPrintBookListWhenOptionOneIsSelected() throws IOException {
        userWillSelectOptionOne();
        menu.runSelectedOption();

        verify(bookCatalog).listBooks();
    }

    private void userWillSelectOptionOne() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
    }

    @Test
    public void shouldDisplayInvalidMessageWhenInvalidInput() throws IOException {
        userWillSelectInvalidThenValidOption();
        menu.runSelectedOption();

        verify(printStream).println(contains("Select a valid option!"));
    }

    private void userWillSelectInvalidThenValidOption() throws IOException {
        when(bufferedReader.readLine()).thenReturn("Hey Nicolette").thenReturn("1");
    }

    @Test
    public void shouldQuitWhenOptionQuitIsSelected() throws IOException {
        userSelectsQuitFromMenu();

        menu.runSelectedOption();

        verify(menu).quit();

    }

    private void userSelectsQuitFromMenu() throws IOException {
        when(bufferedReader.readLine()).thenReturn("0");
    }
}