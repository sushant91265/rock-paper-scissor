package org.game.model;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@NoArgsConstructor
public class CmdLineMoveGenerator implements MoveGenerator {
    private List<String> validMoves = new ArrayList<>();

    public CmdLineMoveGenerator(List<String> validMoves) {
        this.validMoves = validMoves;
    }

    @Override
    public String generateMove() {
//        String move = "";
//        try(var scanner = new Scanner(System.in)){
//            while(true) {
//                System.out.println("Enter your move. Valid moves " + validMoves);
//                String choice = scanner.nextLine().trim().toLowerCase();
//                if (choice.equals("exit")) {
//                    move = "exit";
//                    break;
//                }
//                if (validMoves.contains(choice)) {
//                    move = choice;
//                    break;
//                } else {
//                    System.out.println("Enter correct choice");
//                }
//            }
//        }
//        return move;
        String move = "";
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter you move : ");
            while (true) {
                String line = scanner.nextLine();
                if (line.equalsIgnoreCase("rock")) {
                    move = line;
                    break;
                }
                System.out.println("You entered: " + line);
            }
        }
        return move;
    }
}
