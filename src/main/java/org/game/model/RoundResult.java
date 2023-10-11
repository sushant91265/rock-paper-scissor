package org.game.model;

import org.game.rules.GameRules;

import java.util.Objects;

/**
 * This class represents the result of a round.
 */
public class RoundResult {

    private final boolean isTie;
    private Player winner;

    public RoundResult(Player player1, Player player2, GameRules gameRules) {
        var move1 = player1.getMove();
        var move2 = player2.getMove();

        this.isTie = move1.equals(move2);
        if(!isTie) {
            var win = gameRules.findWinner(move1, move2);
            this.winner = Objects.equals(win, move1) ? player1 : player2;
        }
    }

    public boolean isTie() {
        return this.isTie;
    }

    public Player getWinner() {
        return this.winner;
    }

    public String display() {
        return this.isTie ? "It's a tie!" : this.winner.getName() + " wins!";
    }
}
