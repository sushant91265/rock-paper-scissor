//package org.game.model;
//
//import org.game.rules.GameRules;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//public class RoundResultTest {
//
//    @Test
//    public void testIsTie() {
//        Player player1 = new Player("Player1");
//        Player player2 = Mockito.mock(Player.class);
//        GameRules gameRules = mock(GameRules.class);
//
//        when(gameRules.findWinner(any(), any())).thenReturn(null);
//
//        RoundResult result = new RoundResult(player1, player2, gameRules);
//        assertTrue(result.isTie());
//    }
//
//    @Test
//    public void testGetWinnerPlayer1Wins() {
//        Player player1 = Mockito.mock(Player.class);
//        Player player2 = Mockito.mock(Player.class);
//        GameRules gameRules = mock(GameRules.class);
//
//        when(gameRules.findWinner(any(), any())).thenReturn(player1.getMove());
//
//        RoundResult result = new RoundResult(player1, player2, gameRules);
//        assertEquals(player1, result.getWinner());
//    }
//
//    @Test
//    public void testGetWinnerPlayer2Wins() {
//        Player player1 = Mockito.mock(Player.class);
//        Player player2 = Mockito.mock(Player.class);
//        GameRules gameRules = mock(GameRules.class);
//
//        when(gameRules.findWinner(any(), any())).thenReturn(player2.getMove());
//
//        RoundResult result = new RoundResult(player1, player2, gameRules);
//        assertEquals(player2, result.getWinner());
//    }
//
//    @Test
//    public void testDisplayTie() {
//        Player player1 = Mockito.mock(Player.class);
//        Player player2 = Mockito.mock(Player.class);
//        GameRules gameRules = mock(GameRules.class);
//
//        when(gameRules.findWinner(any(), any())).thenReturn(null); // Simulate a tie
//
//        RoundResult result = new RoundResult(player1, player2, gameRules);
//        assertEquals("It's a tie!", result.display());
//    }
//
//    @Test
//    public void testDisplayPlayer1Wins() {
//        Player player1 = Mockito.mock(Player.class);
//        Player player2 = Mockito.mock(Player.class);
//        GameRules gameRules = mock(GameRules.class);
//
//        when(gameRules.findWinner(any(), any())).thenReturn(player1.getMove());
//
//        RoundResult result = new RoundResult(player1, player2, gameRules);
//        assertEquals("Player1 wins!", result.display());
//    }
//
//    @Test
//    public void testDisplayPlayer2Wins() {
//        Player player1 = Mockito.mock(Player.class);
//        Player player2 = Mockito.mock(Player.class);
//        GameRules gameRules = mock(GameRules.class);
//
//        when(gameRules.findWinner(any(), any())).thenReturn(player2.getMove());
//
//        RoundResult result = new RoundResult(player1, player2, gameRules);
//        assertEquals("Player2 wins!", result.display());
//    }
//}