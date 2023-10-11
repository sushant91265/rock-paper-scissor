package org.game.util;

import org.junit.jupiter.api.Test;

import org.game.rules.GameRules;
import org.game.rules.RockPaperScissorsRules;

import java.util.Properties;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class GameRulesFactoryTest {
    @Test
    public void testGetGameRules() {
        Properties gameProperties = new Properties();
        gameProperties.setProperty("Rock", "Scissors");
        gameProperties.setProperty("Scissors", "Paper");
        gameProperties.setProperty("Paper", "Rock");

        GameRulesFactory gameRulesFactory = new GameRulesFactory(gameProperties);
        GameRules gameRules = gameRulesFactory.getGameRules();

        assertNotNull(gameRules);
        assertTrue(gameRules instanceof RockPaperScissorsRules);

        assertTrue(gameRules.isWinningMove("Rock", "Scissors"));
        assertTrue(gameRules.isWinningMove("Scissors", "Paper"));
        assertTrue(gameRules.isWinningMove("Paper", "Rock"));

        Set<String> expectedValidMoves = Set.of("Rock", "Scissors", "Paper");
        assertIterableEquals(expectedValidMoves, gameRules.getValidMoves());
    }

    @Test
    public void testGetGameRulesWithEmptyPropertiesThrowsException() {
        Properties gameProperties = new Properties();

        GameRulesFactory gameRulesFactory = new GameRulesFactory(gameProperties);
        GameRules gameRules = gameRulesFactory.getGameRules();

        assertNotNull(gameRules);
        assertTrue(gameRules instanceof RockPaperScissorsRules);

        assertThrows(IllegalArgumentException.class, () -> gameRules.isWinningMove("Rock", "Scissors"));
        assertThrows(IllegalArgumentException.class, () -> gameRules.isWinningMove("Scissors", "Paper"));
        assertThrows(IllegalArgumentException.class, () -> gameRules.isWinningMove("Paper", "Rock"));
    }
}
