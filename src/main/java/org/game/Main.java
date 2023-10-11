package org.game;

import org.game.core.GameSession;
import org.game.model.*;
import org.game.rules.GameRules;
import org.game.util.ConfigurationReader;
import org.game.core.GameRulesFactory;
import org.game.util.PlayerUtility;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static class Game {
        private final Integer totalPlayers;
        private final GameRules gameRules;
        private final Integer numberOfRounds;

        private final List<Player> players = new ArrayList<>();

        public Game(int totalPlayers, GameRules gameRules, Integer numberOfRounds){
            this.totalPlayers = totalPlayers;
            this.gameRules = gameRules;
            this.numberOfRounds = numberOfRounds;
        }

        public void addPlayer(Player player) {
            players.add(player);
        }

        public void startGame() {
            int rounds = this.numberOfRounds;
            while(rounds > 0){
                var p1 = players.get(0);
                var p2 = players.get(1);

                var m1 = p1.generateMove();
                var m2 = p2.generateMove();
                System.out.println(m1 + " vs " + m2);
                var winnerMove = gameRules.findWinner(m1, m2);
                var winner = m1.equals(winnerMove) ? p1 : p2;

                System.out.println(winner.getName() + " wins");
                rounds--;
            }
        }

        public String generateMove() {
            String move = "";
            try(var scanner = new Scanner(System.in)){
                while(true) {
                    //System.out.println("Enter your move. Valid moves " + gameRules.getValidMoves());
                    String choice = scanner.nextLine().trim().toLowerCase();
                    if (choice.equals("exit")) {
                        move = "exit";
                        break;
                    }
                    if (gameRules.getValidMoves().contains(choice)) {
                        move = choice;
                        break;
                    } else {
                        System.out.println("Enter correct choice");
                    }
                }
            }
            return move;
        }
    }

    public static void readLinesFromCommandLine(int rounds) {
        String move = "";
        try (Scanner scanner = new Scanner(System.in)) {
            for (int round = 1; round <= rounds; round++) {
                System.out.println("Round " + round + ":");
                while (true) {
                    String line = scanner.nextLine();
                    if (line.equalsIgnoreCase("rock")) {
                        move = line;
                        break;
                    }
                    System.out.println("You entered: " + line);
                }
            }
        }
    }




    public static void main(String[] args) {
        log.info("Welcome to Rock-Paper-Scissors!");
        ConfigurationReader configurationReader = new ConfigurationReader();
        Properties properties = configurationReader.loadGameProperties();
        GameRules rules = createGameRules(properties);
        List<Player> players = createPlayers();

        Game game = null;
//        try (Scanner scanner = new Scanner(System.in)) {
//            String rounds = scanner.nextLine().trim().toLowerCase();
//            game = new Game(2, rules, Integer.parseInt(rounds));
//            game.addPlayer(HumanPlayerFactory.createPlayer("human", rules.getValidMoves()));
//            game.addPlayer(ComputerPlayerFactory.createPlayer("computer", rules.getValidMoves()));
//            readLinesFromCommandLine(scanner);
////            game.startGame();
//        } catch (InputMismatchException e) {
//            log.error("An error occurred while playing the game! Please provide correct input.");
//            log.debug("Exception: ", e);
//        }

        try (Scanner scanner = new Scanner(System.in)) {
            int rounds = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            System.out.println("Enter lines of text (type 'exit' to quit):");
            readLinesFromCommandLine(rounds);
        }
    }

    private static GameRules createGameRules(Properties properties) {
        GameRulesFactory gameRulesFactory = new GameRulesFactory(properties);
        return gameRulesFactory.getGameRules();
    }

    private static List<Player> createPlayers() {
        PlayerUtility playerUtility = new PlayerUtility();
        return playerUtility.createPlayers();
    }

    private static void playGame(GameRules rules, List<Player> players, Scanner scanner) {
        GameSession gameSession = new GameSession(rules, players);
        gameSession.play(scanner);
    }
}

