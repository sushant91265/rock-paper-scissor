package org.game.util;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameUtilityTest {

    @Test
    void testIsValidInput_ValidInput() {
        List<String> validChoices = List.of("rock", "paper", "scissors");
        String input = "rock";

        boolean result = GameUtility.isValidInput(input, validChoices);

        assertTrue(result);
    }

    @Test
    void testIsValidInput_InvalidInput() {
        List<String> validChoices = List.of("rock", "paper", "scissors");
        String input = "invalid";

        boolean result = GameUtility.isValidInput(input, validChoices);

        assertFalse(result);
    }

    @Test
    void testIsValidInput_NullInput() {
        List<String> validChoices = List.of("rock", "paper", "scissors");
        String input = null;

        boolean result = GameUtility.isValidInput(input, validChoices);

        assertFalse(result);
    }

    @Test
    void testIsValidInput_EmptyInput() {
        List<String> validChoices = List.of("rock", "paper", "scissors");
        String input = "";

        boolean result = GameUtility.isValidInput(input, validChoices);

        assertFalse(result);
    }

    @Test
    void testIsValidInput_ValidInput_EmptyList() {
        List<String> validChoices = List.of();
        String input = "rock";

        boolean result = GameUtility.isValidInput(input, validChoices);

        assertFalse(result);
    }

    @Test
    void testIsValidInput_ValidInput_NullList() {
        List<String> validChoices = null;
        String input = "rock";

        boolean result = GameUtility.isValidInput(input, validChoices);

        assertFalse(result);
    }
}