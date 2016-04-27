package com.thoughtworks.tw101.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class BibliotecaTest {


    private List<Book> bookList;
    private PrintStream printStream;
    private Biblioteca biblioteca;

    @Before
    public void setup(){
        printStream = mock(PrintStream.class);
        bookList =  new ArrayList<Book>();
        biblioteca = new Biblioteca(printStream, bookList);
    }

    @Test
    public void shouldWelcomeUserWhenApplicationStarts() {
        biblioteca.start();
        verify(printStream).println(contains("Welcome"));
    }




}