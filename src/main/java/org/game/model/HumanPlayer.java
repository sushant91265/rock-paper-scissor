package org.game.model;

public class HumanPlayer implements Player {

    private final String name;
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
    public String generateMove() {
        return moveGenerator.generateMove();
    }
}
