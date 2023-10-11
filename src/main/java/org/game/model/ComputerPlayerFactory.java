package org.game.model;

import java.util.List;

public class ComputerPlayerFactory implements PlayerFactory {
    @Override
    public Player createPlayer(String name, List<String> possibleMoves){
        return new Player(name, new RandomMoveGenerator(possibleMoves));
    }
}
