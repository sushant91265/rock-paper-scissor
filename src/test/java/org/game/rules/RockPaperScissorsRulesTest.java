package org.game.rules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class RockPaperScissorsRulesTest {

    @Mock
    private Map<String, String> winningMoves;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testFindWinner_Player1Wins() {
        RockPaperScissorsRules rules = new RockPaperScissorsRules(winningMoves);

        when(winningMoves.get("rock")).thenReturn("scissors");
        when(winningMoves.get("scissors")).thenReturn("paper");
        when(winningMoves.get("paper")).thenReturn("rock");

        String result = rules.findWinner("rock", "scissors");

        assertEquals(result, "rock");
    }

    @Test
    void testFindWinner_Player2Wins() {
        RockPaperScissorsRules rules = new RockPaperScissorsRules(winningMoves);

        when(winningMoves.get("rock")).thenReturn("scissors");
        when(winningMoves.get("scissors")).thenReturn("paper");
        when(winningMoves.get("paper")).thenReturn("rock");

        String result = rules.findWinner("scissors", "rock");

        assertEquals(result, "rock");
    }

    @Test
    void testFindWinner_Tie() {
        RockPaperScissorsRules rules = new RockPaperScissorsRules(winningMoves);

        String result = rules.findWinner("rock", "rock");

        assertEquals(result, "Tie");
    }
}