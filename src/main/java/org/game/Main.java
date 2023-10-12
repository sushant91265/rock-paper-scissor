package org.game;

import lombok.extern.slf4j.Slf4j;
import org.game.core.Game;
import org.game.core.GameSession;
import org.game.util.ScannerSingleton;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This is the main class of the game where magic begins.
 */
@Slf4j
public class Main {

    public static void main(String[] args) {
        log.info("Welcome to Rock-Paper-Scissors!");

        try(Scanner scanner = ScannerSingleton.getScanner()) {
            int numRounds = readNumRounds(scanner);

            GameSession gameSession = new GameSession();
            Game game = gameSession.initializeGame(numRounds);
            game.startGame();
        } finally {
            ScannerSingleton.closeScanner();
            log.info("Game Over");
        }
    }

    static int readNumRounds(Scanner scanner) {
        log.info("Enter the number of rounds to play: ");
        int numRounds = scanner.nextInt();
        if (numRounds <= 0) {
            log.error("Number of rounds should be greater than 0");
            throw new InputMismatchException("Number of rounds should be greater than 0");
        }
        scanner.nextLine();
        return numRounds;
    }
}

