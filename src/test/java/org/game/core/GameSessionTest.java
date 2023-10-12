package org.game.core;

import org.game.util.ConfigurationReader;
import org.game.util.ScannerSingleton;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Properties;
import java.util.Scanner;

public class GameSessionTest {

    @Test
    void testInitializeGame() {
        GameSession gameSession = new GameSession();
        ConfigurationReader configurationReader = mock(ConfigurationReader.class);
        Properties properties = new Properties();
        properties.setProperty("rock", "paper");

        when(configurationReader.loadGameProperties("filepath")).thenReturn(properties);

        Scanner scanner = mock(Scanner.class);
        try (MockedStatic<ScannerSingleton> mockedScannerSingleton = mockStatic(ScannerSingleton.class)) {
            mockedScannerSingleton.when(ScannerSingleton::getScanner).thenReturn(scanner);
            when(scanner.nextInt()).thenReturn(5);
            Game game = gameSession.initializeGame(5);

            assertTrue(game.getGameRules().getValidMoves().contains("rock"));
            assertEquals(game.getNumberOfRounds(), 5);
        }
    }
}