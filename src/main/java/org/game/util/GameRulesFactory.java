package org.game.util;

import org.game.rules.GameRules;
import org.game.rules.RockPaperScissorsRules;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class GameRulesFactory {
    public static GameRules createGameRules(Properties properties) {
        Map<String, String> winningMoves = new HashMap<>();
        for (String key : properties.stringPropertyNames()) {
            winningMoves.put(key, properties.getProperty(key));
        }
        return new RockPaperScissorsRules(winningMoves);
    }
}
