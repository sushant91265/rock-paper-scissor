package org.game.model;

import java.util.List;

public interface Player {
    String getName();

    String getMove();

    void setMove(String move);

    void generateMove(List<String> possibleMoves);

    boolean isComputer();

    String generateMove();

}
