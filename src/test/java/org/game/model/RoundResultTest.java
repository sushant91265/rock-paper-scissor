package org.game.model;

import org.game.rules.GameRules;
import org.game.rules.RockPaperScissorsRules;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class RoundResultTest {

    @Test
    public void testTieResult() {
        Player player1 = Mockito.mock(Player.class);
        Player player2 = Mockito.mock(Player.class);
        GameRules gameRules = Mockito.mock(RockPaperScissorsRules.class);

        when(player1.getMove()).thenReturn("Rock");
        when(player2.getMove()).thenReturn("Rock");

        RoundResult result = new RoundResult(player1, player2, gameRules);

        assertTrue(result.isTie());
        assertNull(result.getWinner());
        assertEquals("It's a tie!", result.display());
    }

    @Test
    public void testPlayer1Wins() {
        Player player1 = Mockito.mock(Player.class);
        Player player2 = Mockito.mock(Player.class);

        GameRules gameRules = new RockPaperScissorsRules(Map.of("Rock", "Scissors", "Scissors", "Paper",
                "Paper", "Rock"));

        when(player1.getMove()).thenReturn("Rock");
        when(player2.getMove()).thenReturn("Scissors");
        when(player2.getName()).thenReturn("Bob");
        when(player1.getName()).thenReturn("Alice");

        RoundResult result = new RoundResult(player1, player2, gameRules);

        assertFalse(result.isTie());
        assertEquals(player1.getName(), result.getWinner().getName());
        assertEquals("Alice wins!", result.display());
    }

    @Test
    public void testPlayer2Wins() {
        Player player1 = Mockito.mock(Player.class);
        Player player2 = Mockito.mock(Player.class);
        GameRules gameRules = Mockito.mock(RockPaperScissorsRules.class);

        when(player1.getMove()).thenReturn("Rock");
        when(player2.getMove()).thenReturn("Paper");
        when(player2.getName()).thenReturn("Bob");
        when(player1.getName()).thenReturn("Alice");

        RoundResult result = new RoundResult(player1, player2, gameRules);

        assertFalse(result.isTie());
        assertEquals(player2, result.getWinner());
        assertEquals("Bob wins!", result.display());
    }

    @Test
    public void testDisplayPlayer1Wins() {
        Player player1 = Mockito.mock(Player.class);
        Player player2 = Mockito.mock(Player.class);
        GameRules gameRules = new RockPaperScissorsRules(Map.of("Rock", "Scissors", "Scissors", "Paper",
                "Paper", "Rock"));

        when(player1.getMove()).thenReturn("Rock");
        when(player2.getMove()).thenReturn("Scissors");
        when(player2.getName()).thenReturn("Bob");
        when(player1.getName()).thenReturn("Alice");

        RoundResult result = new RoundResult(player1, player2, gameRules);

        assertEquals("Alice wins!", result.display());
    }

    @Test
    public void testDisplayPlayer2Wins() {
        Player player1 = Mockito.mock(Player.class);
        Player player2 = Mockito.mock(Player.class);
        GameRules gameRules = Mockito.mock(RockPaperScissorsRules.class);

        when(player1.getMove()).thenReturn("Rock");
        when(player2.getMove()).thenReturn("Paper");
        when(player2.getName()).thenReturn("Bob");
        when(player1.getName()).thenReturn("Alice");

        RoundResult result = new RoundResult(player1, player2, gameRules);

        assertEquals("Bob wins!", result.display());
    }
}