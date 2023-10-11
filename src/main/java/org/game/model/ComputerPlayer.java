package org.game.model;

public class ComputerPlayer implements Player {
    private final String name;
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

    @Override
    public String generateMove() {
        return moveGenerator.generateMove();
    }
}
