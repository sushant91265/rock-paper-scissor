package org.game;

import org.game.model.*;
import org.game.rules.GameRules;
import org.game.util.ConfigurationReader;
import org.game.core.GameRulesFactory;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);
    private static int numRounds;

    public static class ScannerSingleton {
        private static Scanner scanner;

        private ScannerSingleton() {
        }

        public static Scanner getScanner() {
            if (scanner == null) {
                scanner = new Scanner(System.in);
            }
            return scanner;
        }

        public static void closeScanner() {
            if (scanner != null) {
                scanner.close();
                scanner = null;
            }
        }
    }

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
            while(rounds > 0) {
                var p1 = players.get(0);
                var p2 = players.get(1);

                var m1 = p1.generateMove();
                var m2 = p2.generateMove();
                log.info(m1 + " vs " + m2);
                var winnerMove = gameRules.findWinner(m1, m2);
                var winner = m1.equals(winnerMove) ? p1 : p2;

                log.info(winner.getName() + " wins");
                rounds--;
            }
            log.debug("Game Over");
            Main.ScannerSingleton.closeScanner();
        }
    }

    public static void main(String[] args) {
        log.info("Welcome to Rock-Paper-Scissors!");
        ConfigurationReader configurationReader = new ConfigurationReader();
        Properties properties = configurationReader.loadGameProperties();
        GameRules rules = createGameRules(properties);

        try {
            Scanner scanner = ScannerSingleton.getScanner();
            log.info("Enter the number of rounds to play: ");
            numRounds = scanner.nextInt();
            scanner.nextLine();

            Game game = new Game(2, rules, numRounds);
            HumanPlayerFactory humanPlayerFactory = new HumanPlayerFactory();
            ComputerPlayerFactory computerPlayerFactory = new ComputerPlayerFactory();
            game.addPlayer(humanPlayerFactory.createPlayer("Human",rules.getValidMoves()));
            game.addPlayer(computerPlayerFactory.createPlayer("Computer",rules.getValidMoves()));
            game.startGame();

        } catch (Exception e) {
            log.error("Invalid input. Please enter a number");
            System.exit(1);
        }
    }

    private static GameRules createGameRules(Properties properties) {
        GameRulesFactory gameRulesFactory = new GameRulesFactory(properties);
        return gameRulesFactory.getGameRules();
    }
}

