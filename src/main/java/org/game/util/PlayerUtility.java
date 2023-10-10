package org.game.util;

import org.game.model.Player;
import org.game.model.PlayerFactory;
import org.game.model.ComputerPlayerFactory;
import org.game.model.HumanPlayerFactory;

import java.util.ArrayList;
import java.util.List;

public class PlayerUtility {

    private static final String HUMAN_PLAYER = "Human Player";
    private static final String COMPUTER_PLAYER = "Computer Player";

    public static List<Player> createPlayers() {
        List<Player> players = new ArrayList<>();
        PlayerFactory humanPlayerFactory = new HumanPlayerFactory();
        PlayerFactory computerPlayerFactory = new ComputerPlayerFactory();

        players.add(humanPlayerFactory.createPlayer(HUMAN_PLAYER));
        players.add(computerPlayerFactory.createPlayer(COMPUTER_PLAYER));

        return players;
    }
}
