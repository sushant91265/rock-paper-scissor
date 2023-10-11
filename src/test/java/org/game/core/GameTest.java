package org.game.core;

import org.game.model.Player;
import org.game.model.RoundResult;
import org.game.rules.GameRules;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class GameTest {

    @Test
    public void testStartGame() {
        GameRules gameRules = Mockito.mock(GameRules.class);

        List<Player> players = new ArrayList<>();
        Player player1 = Mockito.mock(Player.class);
        Player player2 = Mockito.mock(Player.class);
        players.add(player1);
        players.add(player2);

        Game game = new Game(gameRules, 2, players);

        RoundResult roundResult = Mockito.mock(RoundResult.class);

        Mockito.when(roundResult.display()).thenReturn("Round result message");

        Mockito.when(gameRules.findWinner(Mockito.any(), Mockito.any())).thenReturn("Winner");

        Mockito.when(player1.getName()).thenReturn("Player1");
        Mockito.when(player2.getName()).thenReturn("Player2");

        Mockito.when(player1.getMove()).thenReturn("Rock");
        Mockito.when(player2.getMove()).thenReturn("Rock");

        game.startGame();

        Mockito.verify(player1, Mockito.times(2)).getMove();
        Mockito.verify(player2, Mockito.times(2)).getMove();
    }
}