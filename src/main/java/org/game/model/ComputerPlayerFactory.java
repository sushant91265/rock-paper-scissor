package org.game.model;

import java.util.List;

public class ComputerPlayerFactory implements PlayerFactory {
    @Override
    public Player createPlayer(String name) {
        return new ComputerPlayer(name, new RandomMoveGenerator());
    }

    public static Player createPlayer(String name, List<String> possibleMoves){
        return new HumanPlayer(name, new RandomMoveGenerator(possibleMoves));
    }
}
