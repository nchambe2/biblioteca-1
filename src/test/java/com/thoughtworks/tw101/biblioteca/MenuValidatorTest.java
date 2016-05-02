package com.thoughtworks.tw101.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by nicollettec on 4/29/16.
 */
public class MenuValidatorTest {

    private MenuValidator menuValidator;

    @Before
    public void setUp() throws Exception {
        menuValidator = new MenuValidator();
    }

    @Test
    public void shouldReturnTrueWhenUserEntersQuit() {
        String quit = menuValidator.OPTION_QUIT;

        Boolean quitting = menuValidator.isQuit(quit);

        assertThat(quitting, is(true));
    }

    @Test
    public void shouldReturnFalseWhenUserEntersQuit() {
        String notQuitting = "fjksj";

        Boolean quitting = menuValidator.isQuit(notQuitting);

        assertThat(quitting, is(false));
    }

    @Test
    public void shouldReturnValidWhenUserEntersListBooksOption() {
        Boolean isValid = menuValidator.isValidInput(menuValidator.OPTION_LIST_BOOKS);

        assertThat(isValid, is(true));

    }

    @Test
    public void shouldReturnValidWhenUserEntersQuitOption() {
        Boolean isValid = menuValidator.isValidInput(menuValidator.OPTION_QUIT);

        assertThat(isValid, is(true));

    }

    @Test
    public void shouldReturnInvalidWhenUserEnterNonValidOption() {
        String invalidInput = "jklfdjls";
        Boolean isntValid = menuValidator.isValidInput(invalidInput);

        assertThat(isntValid, is(false));

    }


}