package org.game.util;

import org.game.rules.GameRules;

import java.util.List;

public class GameUtility {
    public static boolean isValidInput(String input, GameRules rules) {
        List<String> validChoices = rules.getValidMoves();
        return validChoices.contains(input);
    }
}