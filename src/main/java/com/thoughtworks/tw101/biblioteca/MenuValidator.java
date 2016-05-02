package com.thoughtworks.tw101.biblioteca;

/**
 * Created by nicollettec on 4/29/16.
 */
public class MenuValidator {

    public static final String OPTION_LIST_BOOKS = "1";
    public static final String OPTION_CHECKOUT_BOOKS = "2";
    public static final String OPTION_QUIT = "0";

    public boolean isQuit(String userInput) {
        return userInput.equals(OPTION_QUIT);
    }

    public boolean isValidInput(String userInput) {
        return userInput.equals(OPTION_LIST_BOOKS) || userInput.equals(OPTION_QUIT) || userInput.equals(OPTION_CHECKOUT_BOOKS);
    }
}
