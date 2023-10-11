//package org.game.core;
//
//import org.game.rules.GameRules;
//import org.game.util.ConfigurationReader;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import static org.mockito.Mockito.when;
//
//import java.util.Properties;
//import java.util.Scanner;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class GameSessionTest {
//
//    @Mock
//    private ConfigurationReader configurationReader;
//
//    @Mock
//    private GameRulesFactory gameRulesFactory;
//
//    @Mock
//    private Properties properties;
//
//    @Mock
//    private GameRules gameRules;
//
//    @Mock
//    private Scanner scanner;
//
//    @BeforeEach
//    void setup() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    void testInitializeGame() {
//        GameSession gameSession = new GameSession();
//
//        when(configurationReader.loadGameProperties()).thenReturn(properties);
//        when(scanner.nextInt()).thenReturn(5);
//
//        Game game = gameSession.initializeGame();
//
//        assertEquals(game.getGameRules(), gameRules);
//        assertEquals(game.getNumberOfRounds(), 5);
//    }
//}