package org.game.model;

public class GameResult {
    private final Player player1;
    private final Player player2;
    private final String result;

    public GameResult(Player player1, Player player2, String result) {
        this.player1 = player1;
        this.player2 = player2;
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    @Override
    public String toString() {
        return player1.getName() + " vs. " + player2.getName() + ": " + result;
    }

    public boolean isWinner(Player player) {
        return result.contains(player.getName());
    }
}
