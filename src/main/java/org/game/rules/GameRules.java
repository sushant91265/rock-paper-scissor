package org.game.rules;

import java.util.List;

public interface GameRules {

    List<String> getValidMoves();

    String findWinner(String move1, String move2);
}
