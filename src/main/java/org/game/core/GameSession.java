package org.game.core;

import lombok.extern.slf4j.Slf4j;
import org.game.model.ComputerPlayerFactory;
import org.game.model.HumanPlayerFactory;
import org.game.model.Player;
import org.game.model.PlayerFactory;
import org.game.rules.GameRules;
import org.game.util.ConfigurationReader;
import org.game.util.ScannerSingleton;

import java.util.*;

/**
 * This class is responsible for initializing the game.
 */
@Slf4j
public class GameSession {
    public Game initializeGame() {
        ConfigurationReader configurationReader = new ConfigurationReader();
        Properties properties = configurationReader.loadGameProperties();
        GameRules rules = createGameRules(properties);

        Scanner scanner = ScannerSingleton.getScanner();
        int numRounds = readNumRounds(scanner);

        List<Player> players = createPlayers(rules);

        return new Game(rules, numRounds, players);
    }

    private GameRules createGameRules(Properties properties) {
        GameRulesFactory gameRulesFactory = new GameRulesFactory(properties);
        return gameRulesFactory.getGameRules();
    }

    private int readNumRounds(Scanner scanner) {
        try {
            log.info("Enter the number of rounds to play: ");
            int numRounds = scanner.nextInt();
            scanner.nextLine();
            return numRounds;
        } catch (InputMismatchException e) {
            log.error("Error while reading number of rounds", e);
            throw e;
        }
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
