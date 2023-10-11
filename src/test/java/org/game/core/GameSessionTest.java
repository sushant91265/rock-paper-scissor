//package org.game.core;
//
//import org.game.model.GameResult;
//import org.game.model.Player;
//import org.game.rules.GameRules;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.slf4j.Logger;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//
//public class GameSessionTest {
//    private GameSession gameSession;
//    private Logger mockLogger;
//    private GameRules mockRules;
//
//    @BeforeEach
//    public void setUp() {
//        gameSession = new GameSession();
//        mockLogger = Mockito.mock(Logger.class);
//        mockRules = Mockito.mock(GameRules.class);
//    }
//
//    @Test
//    public void testPlayRound_ComputerPlayer() {
//        Player computerPlayer = Mockito.mock(Player.class);
//        when(computerPlayer.isComputer()).thenReturn(true);
//        List<Player> players = new ArrayList<>();
//        players.add(computerPlayer);
//
//        // Mock the creation of a new GameEngine instance (not the constructor)
//        GameEngine mockGameEngine = Mockito.mock(GameEngine.class);
//
//        when(mockGameEngine.play()).thenReturn(new ArrayList<>()); // Mock the GameEngine's play method
//
//        List<GameResult> results = gameSession.playRound(mockRules, players, null);
//
//        // Verify that playComputerMove was called
//        //verify(computerPlayer).generateMove(mockRules);
//
//        // Verify that the GameEngine was not created, just its play method was called
//        verify(mockGameEngine, never()).play();
//
//        // Ensure that results are returned correctly
//        assertEquals(mockGameEngine.play(), results);
//    }
//
//    @Test
//    public void testPlayRound_HumanPlayer_ValidInput() {
//        Player humanPlayer = Mockito.mock(Player.class);
//        when(humanPlayer.isComputer()).thenReturn(false);
//        when(humanPlayer.getName()).thenReturn("Human");
//        when(humanPlayer.getMove()).thenReturn("Rock"); // Simulate a valid move
//        List<Player> players = new ArrayList<>();
//        players.add(humanPlayer);
//
//        Scanner mockScanner = Mockito.mock(Scanner.class);
//        when(mockScanner.nextLine()).thenReturn("Rock"); // Simulate a valid input
//
//        // Mock the creation of a new GameEngine instance (not the constructor)
//        GameEngine mockGameEngine = Mockito.mock(GameEngine.class);
//
//        when(mockGameEngine.play()).thenReturn(new ArrayList<>()); // Mock the GameEngine's play method
//
//        List<GameResult> results = gameSession.playRound(mockRules, players, mockScanner);
//
//        // Verify that playHumanMove was called
//        verify(humanPlayer).setMove("Rock");
//
//        // Verify that the GameEngine was not created, just its play method was called
//        verify(mockGameEngine, never()).play();
//
//        // Ensure that results are returned correctly
//        assertEquals(mockGameEngine.play(), results);
//    }
//}
