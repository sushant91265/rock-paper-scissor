package org.game.util;

import java.util.List;

public class GameUtility {

    /**
     * This method checks if the input is valid.
     *
     * @param input The input to be checked.
     * @param validChoices The list of valid choices.
     * @return true if the input is valid, false otherwise.
     */
    public static boolean isValidInput(String input, List<String> validChoices) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        return validChoices.contains(input);
    }
}