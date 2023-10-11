package org.game.util;

import org.game.rules.GameRules;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameUtilityTest {
    private GameRules mockGameRules;

    @BeforeEach
    public void setUp() {
        mockGameRules = Mockito.mock(GameRules.class);
    }

    @Test
    public void testIsValidInput_ValidInput() {
        List<String> validChoices = new ArrayList<>();
        validChoices.add("Rock");
        validChoices.add("Scissors");
        validChoices.add("Paper");

        Mockito.when(mockGameRules.getValidMoves()).thenReturn(validChoices);

        assertTrue(GameUtility.isValidInput("Rock", mockGameRules));
    }

    @Test
    public void testIsValidInput_InvalidInput() {
        List<String> validChoices = new ArrayList<>();
        validChoices.add("Rock");
        validChoices.add("Scissors");
        validChoices.add("Paper");

        Mockito.when(mockGameRules.getValidMoves()).thenReturn(validChoices);

        assertFalse(GameUtility.isValidInput("Sword", mockGameRules));
    }
}