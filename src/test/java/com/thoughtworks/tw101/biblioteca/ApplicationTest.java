package com.thoughtworks.tw101.biblioteca;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class ApplicationTest {

    private PrintStream printStream;
    private Application application;
    private BookCatalog bookCatalog;
    private BufferedReader bufferedReader;
    private Menu menu;
    private MenuPrompter prompter;
    private MenuValidator validator;

    @Before
    public void setup() throws IOException {
        printStream = mock(PrintStream.class);
        menu = mock(Menu.class);
        prompter = mock(MenuPrompter.class);
        validator = mock(MenuValidator.class);

        application = new Application(printStream, menu, prompter, validator);
    }

    @Test
    public void shouldWelcomeUserWhenApplicationStarts() throws IOException {
        applicationWillQuitImmediately();

        application.start();
        
        verify(printStream).println(contains("Welcome"));
    }
    
    @Test
    public void shouldShowMenuOptionsAfterWelcomeMessagePrints() throws IOException {
        applicationWillQuitImmediately();

        application.start();
        
        verify(menu).printMenu();
    }


    private void applicationWillQuitImmediately() {
        when(validator.isQuit(anyString())).thenReturn(true);
    }


    @Test
    public void shouldDisplayInvalidMessageWhenInvalidInput() throws IOException {
        String junk = "jdfsljf";
        when(prompter.promptUserForInput()).thenReturn(junk);
        when(validator.isQuit(junk)).thenReturn(false,true);
        when(validator.isValidInput(junk)).thenReturn(false);

        application.start();

        verify(printStream).println(contains("Select a valid option!"));
    }


    @Test
    public void shouldQuitWhenOptionQuitIsSelected() throws IOException {
        when(prompter.promptUserForInput()).thenReturn("0");
        when(validator.isQuit("0")).thenReturn(true);

        application.start();

        verify(printStream).println("Goodbye!");

    }

}