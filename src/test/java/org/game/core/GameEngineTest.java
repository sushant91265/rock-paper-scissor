package org.game.core;

import org.game.model.ComputerPlayer;
import org.game.model.GameResult;
import org.game.model.HumanPlayer;
import org.game.model.Player;
import org.game.rules.GameRules;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GameEngineTest {
    private GameRules gameRules;
    private List<Player> players;
    private GameEngine gameEngine;

    @BeforeEach
    public void setUp() {
        gameRules = mock(GameRules.class);
        players = new ArrayList<>();
        Player player1 = new HumanPlayer("Player1", "Rock");
        Player player2 = new ComputerPlayer("Player2", "Scissors");
        players.add(player1);
        players.add(player2);
        gameEngine = new GameEngine(gameRules, players);
    }

    @Test
    public void testPlayRound_Player1Wins() {
        when(gameRules.isWinningMove("Rock", "Scissors")).thenReturn(true);
        when(gameRules.isWinningMove("Scissors", "Rock")).thenReturn(false);

        List<GameResult> results = gameEngine.play();

        assertEquals(1, results.size());
        GameResult result = results.get(0);
        assertEquals("Player1 wins against Player2!", result.getResult());
    }

    @Test
    public void testPlayRound_Player2Wins() {
        when(gameRules.isWinningMove("Rock", "Scissors")).thenReturn(false);
        when(gameRules.isWinningMove("Scissors", "Rock")).thenReturn(true);

        List<GameResult> results = gameEngine.play();

        assertEquals(1, results.size());
        GameResult result = results.get(0);
        assertEquals("Player2 wins against Player1!", result.getResult());
    }

    @Test
    public void testPlayRound_Tie() {
        when(gameRules.isWinningMove("Rock", "Scissors")).thenReturn(false);
        when(gameRules.isWinningMove("Scissors", "Rock")).thenReturn(false);

        List<GameResult> results = gameEngine.play();

        assertEquals(1, results.size());
        GameResult result = results.get(0);
        assertEquals("It's a tie between Player1 and Player2!", result.getResult());
    }
}
