package org.game.rules;

import java.util.List;

public interface GameRules {
    boolean isWinningMove(String move1, String move2);

    List<String> getValidMoves();
}
