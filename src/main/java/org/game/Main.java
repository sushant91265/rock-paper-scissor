package org.game;

import org.game.core.GameSession;
import org.game.model.*;
import org.game.rules.GameRules;
import org.game.util.ConfigurationReader;
import org.game.util.GameRulesFactory;
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
        GameRulesFactory gameRulesFactory = new GameRulesFactory(properties);
        GameRules rules = gameRulesFactory.getGameRules();

        PlayerUtility playerUtility = new PlayerUtility();
        List<Player> players = playerUtility.createPlayers();

        try (Scanner scanner = new Scanner(System.in)) {
            playGame(scanner, rules, players);
        } catch (InputMismatchException e) {
            log.error("An error occurred while playing the game! Please provide correct input.");
            log.debug("Exception: ", e);
        }
    }

    private static void playGame(Scanner scanner, GameRules rules, List<Player> players) {
        log.info("Enter the number of rounds to play: ");
        int numRounds = scanner.nextInt();
        scanner.nextLine();

        for (int round = 1; round <= numRounds; round++) {
            playRound(round, rules, players, scanner);
        }
    }

    private static void playRound(int round, GameRules rules, List<Player> players, Scanner scanner) {
        log.info("Round {}:", round);
        GameSession gameSession = new GameSession();
        List<GameResult> results = gameSession.playRound(rules, players, scanner);

        results.forEach(result -> log.info(result.toString()));
    }
}
