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

    public List<GameResult> playRound(final GameRules rules, final List<Player> players, final Scanner scanner) {
        for (Player player : players) {
            if (player.isComputer()) {
                playComputerMove(player, rules);
            } else {
                playHumanMove(player, scanner, rules);
            }
        }

        GameEngine game = new GameEngine(rules, players);
        return game.play();
    }

    private void playComputerMove(Player player, GameRules rules) {
        player.generateMove(rules.getValidMoves());
        log.info("{} chose: {}", player.getName(), player.getMove());
    }

    private void playHumanMove(Player player, Scanner scanner, GameRules rules) {
        while (true) {
            log.info("{}, enter your choice: ",player.getName());
            String choice = scanner.nextLine().trim().toLowerCase();

            if (GameUtility.isValidInput(choice, rules)) {
                player.setMove(choice);
                break;
            } else {
                log.info("Invalid input. Please enter a valid choice.");
            }
        }
    }
}
