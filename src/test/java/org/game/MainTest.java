package org.game;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.InputMismatchException;
import java.util.Scanner;
public class MainTest {

    @Test
    public void testReadNumRoundsValidInput() {
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextInt()).thenReturn(3);

        int numRounds = Main.readNumRounds(mockScanner);

        assertEquals(3, numRounds);
        verify(mockScanner, times(1)).nextInt();
        verify(mockScanner, times(1)).nextLine();
    }

    @Test
    public void testReadNumRoundsInvalidInput() {
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextInt()).thenReturn(-1);

        assertThrows(InputMismatchException.class, () -> {
            Main.readNumRounds(mockScanner);
        });

        verify(mockScanner, times(1)).nextInt();
    }
}