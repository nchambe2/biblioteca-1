package com.thoughtworks.tw101.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by nicollettec on 4/29/16.
 */
public class MenuPrompter {
    private BufferedReader bufferedReader;

    public MenuPrompter(BufferedReader reader){

        this.bufferedReader = reader;
    }

    public String promptUserForInput() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
