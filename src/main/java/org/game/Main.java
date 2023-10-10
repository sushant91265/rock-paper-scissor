package org.game;

import org.game.core.GameSession;
import org.game.model.*;
import org.game.rules.GameRules;
import org.game.util.ConfigurationReader;
import org.game.util.GameRulesFactory;
import org.game.util.PlayerUtility;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Welcome to Rock-Paper-Scissors!");

        GameRules rules = GameRulesFactory.createGameRules(ConfigurationReader.loadGameProperties());
        List<Player> players = PlayerUtility.createPlayers();

        try (Scanner scanner = new Scanner(System.in)) {
            log.info("Enter the number of rounds to play: ");

            int numRounds = scanner.nextInt();
            scanner.nextLine();

            for (int round = 1; round <= numRounds; round++) {
                log.info("Round {}:", round);
                GameSession gameSession = new GameSession();
                List<GameResult> results = gameSession.playRound(rules, players, scanner);

                results.forEach(result -> log.info(result.toString()));
            }
        } catch (InputMismatchException e) {
            log.error("An error occurred while playing the game! Please provide correct input.");
            log.debug("Exception: ", e);
        }
    }
}