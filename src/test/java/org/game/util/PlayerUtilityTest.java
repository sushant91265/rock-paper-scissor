package org.game.util;

import org.game.model.ComputerPlayer;
import org.game.model.HumanPlayer;
import org.game.model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerUtilityTest {
    private PlayerUtility playerUtility;

    @BeforeEach
    public void setUp() {
        playerUtility = new PlayerUtility();
    }

    @Test
    public void testCreatePlayers() {
        List<Player> players = playerUtility.createPlayers();

        assertEquals(2, players.size());

        Player player1 = players.get(0);
        assertEquals("Human Player", player1.getName());
        assertTrue(player1 instanceof HumanPlayer);

        Player player2 = players.get(1);
        assertEquals("Computer Player", player2.getName());
        assertTrue(player2 instanceof ComputerPlayer);
    }
}