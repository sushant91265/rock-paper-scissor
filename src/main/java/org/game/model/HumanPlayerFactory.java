package org.game.model;

import java.util.List;

public class HumanPlayerFactory implements PlayerFactory {
    @Override
    public Player createPlayer(String name, List<String> validMoves){
        return new Player(name, new CmdLineMoveGenerator(validMoves));
    }
}
