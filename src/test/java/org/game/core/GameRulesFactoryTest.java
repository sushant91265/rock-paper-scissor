package org.game.core;

import org.game.rules.GameRules;
import org.game.rules.RockPaperScissorsRules;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class GameRulesFactoryTest {

    @Mock
    private Properties properties;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateGameRules() {
        Properties sampleProperties = new Properties();
        sampleProperties.setProperty("Rock", "Scissors");
        sampleProperties.setProperty("Paper", "Rock");
        sampleProperties.setProperty("Scissors", "Paper");

        when(properties.stringPropertyNames()).thenReturn(sampleProperties.stringPropertyNames());
        when(properties.getProperty("Rock")).thenReturn("Scissors");
        when(properties.getProperty("Paper")).thenReturn("Rock");
        when(properties.getProperty("Scissors")).thenReturn("Paper");

        GameRulesFactory gameRulesFactory = new GameRulesFactory(properties);
        GameRules gameRules = gameRulesFactory.getGameRules();

        assertEquals(RockPaperScissorsRules.class, gameRules.getClass());
    }

    @Test
    public void testCreateGameRulesWithEmptyProperties() {
        Properties sampleProperties = new Properties();

        when(properties.stringPropertyNames()).thenReturn(sampleProperties.stringPropertyNames());

        GameRulesFactory gameRulesFactory = new GameRulesFactory(properties);
        GameRules gameRules = gameRulesFactory.getGameRules();

        assertEquals(RockPaperScissorsRules.class, gameRules.getClass());
    }
}