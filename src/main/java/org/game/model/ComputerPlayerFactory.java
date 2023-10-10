package org.game.model;

public class ComputerPlayerFactory implements PlayerFactory {
    @Override
    public Player createPlayer(String name) {
            return new ComputerPlayer(name);
        }
}
