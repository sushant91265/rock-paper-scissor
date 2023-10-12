package org.game.core;

import org.game.model.ComputerPlayerFactory;
import org.game.rules.RockPaperScissorsRules;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

//Simulation test for the game with 50 computer players
public class SimulationTest {

    @Test
    public void testSimulation() {
        int rounds = 50;
        var cf = new ComputerPlayerFactory();
        var p1 = cf.createPlayer("p1", List.of("rock", "paper", "scissors"));
        var p2 = cf.createPlayer("p2", List.of("rock", "paper", "scissors"));
        var gr = new RockPaperScissorsRules(Map.of(
                "rock", "scissors",
                "paper", "rock",
                "scissors", "paper"
        ));
        Game game = new Game(gr, rounds, List.of(p1, p2));
        game.startGame();
    }
}
