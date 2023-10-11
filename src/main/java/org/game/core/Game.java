package org.game.core;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.game.model.Player;
import org.game.model.RoundResult;
import org.game.rules.GameRules;
import org.game.util.ScannerSingleton;

import java.util.List;

/**
 * This class represents the game itself. It is responsible for creating the players and starting the game.
 */
@Slf4j
@Getter
public class Game {
    private final GameRules gameRules;
    private final Integer numberOfRounds;
    private final List<Player> players;

    public Game(GameRules gameRules, Integer numberOfRounds, List<Player> players) {
        this.gameRules = gameRules;
        this.numberOfRounds = numberOfRounds;
        this.players = players;
    }

    public void startGame() {
        int rounds = this.numberOfRounds;
        while(rounds > 0) {
            var p1 = this.players.get(0);
            var p2 = this.players.get(1);

            RoundResult roundResult = new RoundResult(p1, p2, gameRules);
            log.info("Round {} {}", this.numberOfRounds - rounds + 1, roundResult.display());
            rounds--;
        }
    }
}
