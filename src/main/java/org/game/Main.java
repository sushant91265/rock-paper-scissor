package org.game;

import org.game.core.GameSession;
import org.game.model.*;
import org.game.rules.GameRules;
import org.game.util.ConfigurationReader;
import org.game.core.GameRulesFactory;
import org.game.util.PlayerUtility;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Welcome to Rock-Paper-Scissors!");

        ConfigurationReader configurationReader = new ConfigurationReader();
        Properties properties = configurationReader.loadGameProperties();
        GameRules rules = createGameRules(properties);
        List<Player> players = createPlayers();

        try (Scanner scanner = new Scanner(System.in)) {
            playGame(rules, players, scanner);
        } catch (InputMismatchException e) {
            log.error("An error occurred while playing the game! Please provide correct input.");
            log.debug("Exception: ", e);
        }
    }

    private static GameRules createGameRules(Properties properties) {
        GameRulesFactory gameRulesFactory = new GameRulesFactory(properties);
        return gameRulesFactory.getGameRules();
    }

    private static List<Player> createPlayers() {
        PlayerUtility playerUtility = new PlayerUtility();
        return playerUtility.createPlayers();
    }

    private static void playGame(GameRules rules, List<Player> players, Scanner scanner) {
        GameSession gameSession = new GameSession(rules, players);
        gameSession.play(scanner);
    }
}

