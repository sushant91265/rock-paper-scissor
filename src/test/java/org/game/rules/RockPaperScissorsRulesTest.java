package org.game.rules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class RockPaperScissorsRulesTest {
    private RockPaperScissorsRules gameRules;

    @BeforeEach
    public void setUp() {
        Map<String, String> winningMoves = new HashMap<>();
        winningMoves.put("Rock", "Scissors");
        winningMoves.put("Scissors", "Paper");
        winningMoves.put("Paper", "Rock");
        gameRules = new RockPaperScissorsRules(winningMoves);
    }

    @Test
    public void testIsWinningMove_WinningCase() {
        assertTrue(gameRules.isWinningMove("Rock", "Scissors"));
        assertTrue(gameRules.isWinningMove("Scissors", "Paper"));
        assertTrue(gameRules.isWinningMove("Paper", "Rock"));
    }

    @Test
    public void testIsWinningMove_LosingCase() {
        assertFalse(gameRules.isWinningMove("Scissors", "Rock"));
        assertFalse(gameRules.isWinningMove("Paper", "Scissors"));
        assertFalse(gameRules.isWinningMove("Rock", "Paper"));
    }

    @Test
    public void testIsWinningMove_TieCase() {
        assertFalse(gameRules.isWinningMove("Rock", "Rock"));
        assertFalse(gameRules.isWinningMove("Scissors", "Scissors"));
        assertFalse(gameRules.isWinningMove("Paper", "Paper"));
    }

    @Test
    public void testGetValidMoves() {
        List<String> validMoves = gameRules.getValidMoves();

        assertEquals(3, validMoves.size());
        assertTrue(validMoves.contains("Rock"));
        assertTrue(validMoves.contains("Scissors"));
        assertTrue(validMoves.contains("Paper"));
    }
}