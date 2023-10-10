package org.game;

import org.game.core.GameEngine;
import org.game.model.GameResult;
import org.game.model.Player;
import org.game.model.PlayerFactory;
import org.game.rules.GameRules;
import org.game.util.GameRulesFactory;
import org.game.model.ComputerPlayerFactory;
import org.game.model.HumanPlayerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Properties configProperties = new Properties();
        try {
            FileInputStream configFis = new FileInputStream("game_config.properties");
            configProperties.load(configFis);
            configFis.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Read the number of players from the config file
        int numPlayers = Integer.parseInt(configProperties.getProperty("num_players"));

        GameRules rules = GameRulesFactory.createGameRules(loadGameProperties());

        List<Player> players = createPlayers(numPlayers);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter your choice or type 'exit' to quit: ");
            String player1Choice = scanner.nextLine().trim().toLowerCase();

            if (player1Choice.equals("exit")) {
                break; // Exit the game loop
            }

            // Validate user input based on configuration
            if (!isValidInput(player1Choice, rules)) {
                System.out.println("Invalid input. Please enter a valid choice.");
                continue; // Continue the game loop
            }

            // Set the human player's move and play the game
            players.get(0).setMove(player1Choice);
            GameEngine game = new GameEngine(rules, players);
            List<GameResult> results = game.play();

            results.forEach(System.out::println);
        }

        scanner.close();
    }

    private static Properties loadGameProperties() {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("game.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    private static List<Player> createPlayers(int numPlayers) {
        List<Player> players = new ArrayList<>();
        PlayerFactory humanPlayerFactory = new HumanPlayerFactory();
        PlayerFactory computerPlayerFactory = new ComputerPlayerFactory();

        for (int i = 0; i < numPlayers; i++) {
            players.add(humanPlayerFactory.createPlayer("Player " + (i + 1)));
        }
        return players;
    }

    // Modularized input validation function
    private static boolean isValidInput(String input, GameRules rules) {
        List<String> validChoices = rules.getValidMoves();
        return validChoices.contains(input);
    }
}