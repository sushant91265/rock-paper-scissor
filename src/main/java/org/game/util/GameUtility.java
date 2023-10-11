package org.game.util;

import org.game.rules.GameRules;

import java.util.List;

public class GameUtility {

    /**
     * This method checks if the input is valid.
     *
     * @param input The input to be checked.
     * @param rules The rules of the game.
     * @return true if the input is valid, false otherwise.
     */
    public static boolean isValidInput(String input, GameRules rules) {
        List<String> validChoices = rules.getValidMoves();
        return validChoices.contains(input);
    }
}