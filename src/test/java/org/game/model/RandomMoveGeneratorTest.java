package org.game.model;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomMoveGeneratorTest {

    @Test
    public void testGenerateMove() {
        List<String> possibleMoves = Arrays.asList("Rock", "Paper", "Scissors");

        Random randomMock = Mockito.mock(Random.class);

        Mockito.when(randomMock.nextInt(possibleMoves.size())).thenReturn(1);

        RandomMoveGenerator moveGenerator = new RandomMoveGenerator(possibleMoves);

        String move = moveGenerator.generateMove();

        assertEquals("Paper", move);
    }
}