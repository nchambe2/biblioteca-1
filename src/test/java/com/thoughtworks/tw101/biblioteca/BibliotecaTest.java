package com.thoughtworks.tw101.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class BibliotecaTest {

    private PrintStream printStream;
    private Biblioteca biblioteca;
    private BookCatalog bookCatalog;
    private BufferedReader bufferedReader;
    private Menu menu;

    @Before
    public void setup() throws IOException {
        printStream = mock(PrintStream.class);
        menu = mock(Menu.class);
        biblioteca = new Biblioteca(printStream, menu);
    }

    @Test
    public void shouldWelcomeUserWhenApplicationStarts() throws IOException {
        userWillSelectAnyOption();
        biblioteca.start();
        
        verify(printStream).println(contains("Welcome"));
    }
    
    @Test
    public void shouldShowMenuOptionsAfterWelcomeMessagePrints() throws IOException {
        userWillSelectAnyOption();
        biblioteca.start();
        
        verify(menu).printMenu();
    }

    @Test
    public void shouldRunSelectedMenuOptionWhenUserMakesASelection() throws IOException {
        userWillSelectOptionOne();
        biblioteca.start();

        verify(menu).runSelectedOption("1");
    }

    private void userWillSelectOptionOne() throws IOException {
        when(menu.getUserInput()).thenReturn("1");
    }

    private void userWillSelectAnyOption() throws IOException {
        when(menu.getUserInput()).thenReturn("");
    }
}