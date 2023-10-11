package org.game.model;

import java.util.List;

public class HumanPlayer implements Player {

    private final String name;
    private String move;

    public HumanPlayer(String name, String move) {
        this.name = name;
        this.move = move;
    }

    //TODO: check constructors
    public HumanPlayer(String name) {
        this.name = name;
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
}
