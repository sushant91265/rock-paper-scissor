package org.game;

import org.game.core.GameEngine;
import org.game.model.*;
import org.game.rules.GameRules;
import org.game.util.GameRulesFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Properties configProperties = new Properties();
        try(FileInputStream configFis = new FileInputStream("src/main/resources/game_config.properties")) {
            configProperties.load(configFis);
        } catch (IOException e) {
            System.out.println("Error loading config file. Exiting...");
            return;
        }

        int numRounds = Integer.parseInt(configProperties.getProperty("num_rounds"));

        GameRules rules = GameRulesFactory.createGameRules(loadGameProperties());

        List<Player> players = createPlayers();
        Scanner scanner = new Scanner(System.in);
        for (int round = 1; round <= numRounds; round++) {
            System.out.println("Round " + round + ":");

            for (Player player : players) {
                if (player.isComputer()) {
                    player.generateMove(rules.getValidMoves());
                } else {
                    while (true) {
                        System.out.print(player.getName() + ", enter your choice: ");
                        String choice = scanner.nextLine().trim().toLowerCase();

                        if (isValidInput(choice, rules)) {
                            player.setMove(choice);
                            break;
                        } else {
                            System.out.println("Invalid input. Please enter a valid choice.");
                        }
                    }
                }
            }

            // Calculate and display results
            GameEngine game = new GameEngine(rules, players);
            List<GameResult> results = game.play();

            results.forEach(System.out::println);
        }
        scanner.close();
    }

    private static Properties loadGameProperties() {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/resources/game.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            System.out.println("Error loading game properties. Exiting...");
            System.exit(1);
        }
        return properties;
    }

    private static List<Player> createPlayers() {
        List<Player> players = new ArrayList<>();
        PlayerFactory humanPlayerFactory = new HumanPlayerFactory();
        PlayerFactory computerPlayerFactory = new ComputerPlayerFactory();

        players.add(humanPlayerFactory.createPlayer("Human Player"));
        players.add(computerPlayerFactory.createPlayer("Computer Player"));

        return players;
    }

    private static boolean isValidInput(String input, GameRules rules) {
        List<String> validChoices = rules.getValidMoves();
        return validChoices.contains(input);
    }
}