package org.game.model;

import java.util.List;

public class HumanPlayer implements Player {

    private final String name;
    private String move;
    private MoveGenerator moveGenerator;

    public HumanPlayer(String name, MoveGenerator moveGenerator) {
        this.name = name;
        this.moveGenerator = moveGenerator;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getMove() {
        return move;
    }

    @Override
    public void setMove(String move) {
        this.move = move;
    }

    @Override
    public void generateMove(List<String> possibleMoves) {

        //as a human player, we don't need to generate a move
    }

    @Override
    public boolean isComputer() {
        return false;
    }

    @Override
    public String generateMove() {
        return moveGenerator.generateMove();
    }
}
