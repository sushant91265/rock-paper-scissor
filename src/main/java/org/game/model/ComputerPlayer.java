package org.game.model;

import java.util.List;

public class ComputerPlayer implements Player {
    private final String name;
    private String move;

    public ComputerPlayer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setMove(String move) {
        this.move = move;
    }

    @Override
    public String getMove() {
        return move;
    }

    @Override
    public void generateMove(List<String> possibleMoves) {
        int randomIndex = (int) (Math.random() * possibleMoves.size());
        setMove(possibleMoves.get(randomIndex));
    }
}
