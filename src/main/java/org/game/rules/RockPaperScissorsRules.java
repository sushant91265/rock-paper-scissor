package org.game.rules;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This class implements the GameRules interface and provides the rules for the Rock-Paper-Scissors game.
 * Winning moves are the mappings defined in the properties file.
 * Valid moves are the keys of the winning moves.
 */
public class RockPaperScissorsRules implements GameRules {
    private final Map<String, String> winningMoves;
    private final List<String> validMoves;

    public RockPaperScissorsRules(Map<String, String> winningMoves) {
        this.winningMoves = winningMoves;
        this.validMoves = new ArrayList<>(winningMoves.keySet());
    }

    @Override
    public List<String> getValidMoves() {
        return this.validMoves;
    }

    @Override
    public String findWinner(String move1, String move2) {
        if (move1.equals(move2)) {
            return "Tie";
        }
        return this.winningMoves.get(move1).equals(move2) ?  move1 : move2;
    }
}
