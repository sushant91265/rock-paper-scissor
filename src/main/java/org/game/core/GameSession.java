package org.game.core;

import org.game.model.GameResult;
import org.game.model.Player;
import org.game.rules.GameRules;
import org.game.util.GameUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

/**
 * The GameSession class is responsible for playing the game.
 * It generates the moves for the computer players and takes input from the human players.
 */
public class GameSession {

    private static final Logger log = LoggerFactory.getLogger(GameSession.class);
    private static final String EXIT_COMMAND = "exit";

    private final GameRules rules;
    private final List<Player> players;

    public GameSession(GameRules rules, List<Player> players) {
        this.rules = rules;
        this.players = players;
    }

    public void play(Scanner scanner) {
        log.info("Enter the number of rounds to play: ");
        int numRounds = scanner.nextInt();
        scanner.nextLine();

        for (int round = 1; round <= numRounds; round++) {
            playRound(round, scanner);
        }
    }

    private void playRound(int round, Scanner scanner) {
        log.info("Round {}:", round);

        for (Player player : players) {
            if (player.isComputer()) {
                playComputerMove(player);
            } else {
                if (!playHumanMove(player, scanner)) {
                    return;
                }
            }
        }

        GameEngine gameEngine = new GameEngine(rules, players);
        List<GameResult> results = gameEngine.play();

        results.forEach(result -> log.info(result.toString()));
    }

    private void playComputerMove(Player player) {
        player.generateMove(rules.getValidMoves());
        log.info("{} chose: {}", player.getName(), player.getMove());
    }

    private boolean playHumanMove(Player player, Scanner scanner) {
        while (true) {
            log.info("{}, enter your choice (type 'exit' to end the game): ", player.getName());
            String choice = scanner.nextLine().trim().toLowerCase();

            if (choice.equals(EXIT_COMMAND)) {
                log.info("Exiting the game.");
                return false;
            }

            if (GameUtility.isValidInput(choice, rules)) {
                player.setMove(choice);
                break;
            } else {
                log.info("Invalid input. Please enter a valid choice.");
            }
        }
        return true;
    }
}
