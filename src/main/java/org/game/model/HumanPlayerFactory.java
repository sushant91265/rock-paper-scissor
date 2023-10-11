package org.game.model;

import java.util.List;

public class HumanPlayerFactory implements PlayerFactory {
    @Override
    public Player createPlayer(String name) {
        return new HumanPlayer(name, new CmdLineMoveGenerator());
    }

    public static Player createPlayer(String name, List<String> validMoves){
        return new HumanPlayer(name, new CmdLineMoveGenerator(validMoves));
    }
}
