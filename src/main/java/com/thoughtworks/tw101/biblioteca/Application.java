package com.thoughtworks.tw101.biblioteca;

import java.io.PrintStream;

public class Application {

    private PrintStream printStream;
    private Menu menu;
    private MenuPrompter prompter;
    private MenuValidator validator;

    public Application(PrintStream printStream, Menu menu, MenuPrompter prompter, MenuValidator validator) {
        this.printStream = printStream;
        this.menu = menu;
        this.prompter = prompter;
        this.validator = validator;
    }

    public void start() {
        printWelcomeMessage();
        menu.printMenu();

        String userInput = prompter.promptUserForInput();

        while(!validator.isQuit(userInput)){

            if(!validator.isValidInput(userInput)){
                printStream.println("Select a valid option!");
            }
            else {

                menu.runSelectedOption(userInput);
            }

            menu.printMenu();
            userInput = prompter.promptUserForInput();

        }

        printStream.println("Goodbye!");
    }

    private void printWelcomeMessage() {
        printStream.println("Welcome");
    }

}
