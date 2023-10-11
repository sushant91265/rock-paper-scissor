package org.game.model;

import java.util.List;
public interface PlayerFactory {
    Player createPlayer(String name);

    Player createPlayer(String name, List<String> validMoves);
}
