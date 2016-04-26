package com.thoughtworks.tw101.biblioteca;

import java.io.PrintStream;

public class Application {

    private PrintStream printStream;

    public Application(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void start() {
        printStream.println("Welcome");
    }
}
