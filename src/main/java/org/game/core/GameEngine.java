package org.game.core;

import org.game.model.GameResult;
import org.game.model.Player;
import org.game.rules.GameRules;

import java.util.ArrayList;
import java.util.List;

public class GameEngine {
    private final GameRules rules;
    private final List<Player> players;

    public GameEngine(GameRules rules, List<Player> players) {
        this.rules = rules;
        this.players = players;
    }

    public List<GameResult> play() {
        List<GameResult> results = new ArrayList<>();

        for (int i = 0; i < players.size(); i++) {
            for (int j = i + 1; j < players.size(); j++) {
                Player player1 = players.get(i);
                Player player2 = players.get(j);

                player1.generateMove(rules.getValidMoves());

                if (player2.isComputer()) {
                    player2.generateMove(rules.getValidMoves());
                }

                String move1 = player1.getMove();
                String move2 = player2.getMove();
                System.out.println(player1.getName() + " plays " + move1 + " against " + player2.getName() + " who plays " + move2);
                String result;
                if (rules.isWinningMove(move1, move2)) {
                    result = player1.getName() + " wins against " + player2.getName() + "!";
                } else if (rules.isWinningMove(move2, move1)) {
                    result = player2.getName() + " wins against " + player1.getName() + "!";
                } else {
                    result = "It's a tie between " + player1.getName() + " and " + player2.getName() + "!";
                }

                results.add(new GameResult(player1, player2, result));
            }
        }
        return results;
    }
}
