package org.game;

import lombok.extern.slf4j.Slf4j;
import org.game.core.Game;
import org.game.core.GameSession;

/**
 * This is the main class of the game where magic begins.
 */
@Slf4j
public class Main {

    public static void main(String[] args) {
        log.info("Welcome to Rock-Paper-Scissors!");
        GameSession gameSession = new GameSession();

        Game game = gameSession.initializeGame();
        game.startGame();

        log.info("Game Over");
    }
}

