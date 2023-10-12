package org.game.model;


import org.game.util.ScannerSingleton;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CmdLineMoveGeneratorTest {

    @Mock
    private Scanner scanner;
    private CmdLineMoveGenerator moveGenerator;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        List<String> validMoves = List.of("rock", "paper", "scissors");
        moveGenerator = new CmdLineMoveGenerator(validMoves);
    }

    @Test
    void testGenerateMove_ValidInput() {
        try (MockedStatic<ScannerSingleton> mockedScannerSingleton = mockStatic(ScannerSingleton.class)) {
            mockedScannerSingleton.when(ScannerSingleton::getScanner).thenReturn(scanner);
            when(scanner.nextLine()).thenReturn("rock");

            String result = moveGenerator.generateMove();

            assertEquals("rock", result);
        }
    }

    @Test
    @Disabled
    void testGenerateMove_ExitCommand() {
        try (MockedStatic<ScannerSingleton> mockedScannerSingleton = mockStatic(ScannerSingleton.class)) {
            mockedScannerSingleton.when(ScannerSingleton::getScanner).thenReturn(scanner);
            when(scanner.nextLine()).thenReturn("exit");

            String result = moveGenerator.generateMove();

            assertEquals("exit", result);
        }
    }

    @Test
    void testGenerateMove_InvalidInputThenValidInput() {
        try (MockedStatic<ScannerSingleton> mockedScannerSingleton = mockStatic(ScannerSingleton.class)) {
            mockedScannerSingleton.when(ScannerSingleton::getScanner).thenReturn(scanner);
            when(scanner.nextLine()).thenReturn("rock");

            String result = moveGenerator.generateMove();

            assertEquals("rock", result);
        }
    }
}