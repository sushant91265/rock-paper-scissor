package org.game.core;

import org.game.rules.GameRules;
import org.game.rules.RockPaperScissorsRules;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class GameRulesFactory {
    private final GameRules gameRules;

    public GameRulesFactory(Properties properties) {
        Map<String, String> winningMoves = new HashMap<>();
        for (String key : properties.stringPropertyNames()) {
            winningMoves.put(key, properties.getProperty(key));
        }
        gameRules = new RockPaperScissorsRules(winningMoves);
    }

    public GameRules getGameRules() {
        return gameRules;
    }
}
