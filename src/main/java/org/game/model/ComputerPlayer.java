package org.game.model;

import java.util.List;

public class ComputerPlayer implements Player {
    private final String name;
    private String move;
    private MoveGenerator moveGenerator;

    public ComputerPlayer(String name, MoveGenerator moveGenerator)
    {
        this.name = name;
        this.moveGenerator = moveGenerator;
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
    public boolean isComputer() {
        return true;
    }

    @Override
    public String generateMove() {
        return moveGenerator.generateMove();
    }

    @Override
    public void generateMove(List<String> possibleMoves) {
        int randomIndex = (int) (Math.random() * possibleMoves.size());
        this.setMove(possibleMoves.get(randomIndex));
    }
}
