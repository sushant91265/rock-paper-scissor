package org.game.rules;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RockPaperScissorsRules implements GameRules {
    private final Map<String, String> winningMoves;
    private final List<String> validMoves;

    public RockPaperScissorsRules(Map<String, String> winningMoves) {
        this.winningMoves = winningMoves;
        this.validMoves = new ArrayList<>(winningMoves.keySet());
    }

    @Override
    public boolean isWinningMove(String move1, String move2) {
        return winningMoves.get(move1).equals(move2);
    }

    @Override
    public List<String> getValidMoves() {
        return validMoves;
    }
}
