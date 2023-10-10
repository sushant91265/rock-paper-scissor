package org.game.model;

public class HumanPlayerFactory implements PlayerFactory {
    @Override
    public Player createPlayer(String name) {
        return new HumanPlayer(name);
    }
}
