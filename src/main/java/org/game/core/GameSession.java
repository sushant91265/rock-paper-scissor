package org.game.core;

import lombok.extern.slf4j.Slf4j;
import org.game.model.ComputerPlayerFactory;
import org.game.model.HumanPlayerFactory;
import org.game.model.Player;
import org.game.model.PlayerFactory;
import org.game.rules.GameRules;
import org.game.util.ConfigurationReader;

import java.util.*;

/**
 * This class is responsible for initializing the game.
 */
@Slf4j
public class GameSession {

    private final String GAME_PROPERTIES_FILE = "src/main/resources/game.properties";

    public Game initializeGame(int numRounds) {
        ConfigurationReader configurationReader = new ConfigurationReader();
        Properties properties = configurationReader.loadGameProperties(GAME_PROPERTIES_FILE);
        GameRules rules = createGameRules(properties);

        List<Player> players = createPlayers(rules);

        return new Game(rules, numRounds, players);
    }

    private GameRules createGameRules(Properties properties) {
        GameRulesFactory gameRulesFactory = new GameRulesFactory(properties);
        return gameRulesFactory.getGameRules();
    }

    private List<Player> createPlayers(GameRules rules) {
        List<Player> players = new ArrayList<>();
        PlayerFactory humanPlayerFactory = new HumanPlayerFactory();
        PlayerFactory computerPlayerFactory = new ComputerPlayerFactory();

        players.add(humanPlayerFactory.createPlayer("Human", rules.getValidMoves()));
        players.add(computerPlayerFactory.createPlayer("Computer", rules.getValidMoves()));

        return players;
    }
}
