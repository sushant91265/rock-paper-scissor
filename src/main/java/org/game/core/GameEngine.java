//package org.game.core;
//
//import org.game.model.GameResult;
//import org.game.model.Player;
//import org.game.rules.GameRules;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * The GameEngine class is responsible for playing the game.
// * It takes a list of players and a set of rules and plays the game.
// * It returns a list of GameResult objects, one for each round played.
// */
//class GameEngine {
//    private final GameRules rules;
//    private final List<Player> players;
//
//    public GameEngine(GameRules rules, List<Player> players) {
//        this.rules = rules;
//        this.players = players;
//    }
//
//    public List<GameResult> play() {
//        List<GameResult> results = new ArrayList<>();
//
//        Player player1 = players.get(0);
//        Player player2 = players.get(1);
//
//        GameResult result = playRound(player1, player2);
//        results.add(result);
//        return results;
//    }
//
//    private GameResult playRound(Player player1, Player player2) {
//        String move1 = player1.getMove();
//        String move2 = player2.getMove();
//
//       // String roundResult = determineRoundResult(player1, player2, move1, move2);
//
//      /  return new GameResult(player1, player2, roundResult);
//    }
//
////    private String determineRoundResult(Player player1, Player player2, String move1, String move2) {
////        if (rules.isWinningMove(move1, move2)) {
////            return player1.getName() + " wins against " + player2.getName() + "!";
////        } else if (rules.isWinningMove(move2, move1)) {
////            return player2.getName() + " wins against " + player1.getName() + "!";
////        } else {
////            return "It's a tie between " + player1.getName() + " and " + player2.getName() + "!";
////        }
////    }
//}
