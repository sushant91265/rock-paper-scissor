package org.game.model;

import lombok.extern.slf4j.Slf4j;
import org.game.Main;

import java.util.List;
import java.util.Scanner;

@Slf4j
public class CmdLineMoveGenerator implements MoveGenerator {
    private final List<String> validMoves;
    private static final String EXIT = "exit";

    public CmdLineMoveGenerator(List<String> validMoves) {
        this.validMoves = validMoves;
    }

    @Override
    public String generateMove() {
        String move = "";
        try {
            Scanner scanner = Main.ScannerSingleton.getScanner();
            while(true) {
                log.info("Enter your move. Valid moves {}", validMoves);
                String choice = scanner.nextLine().trim().toLowerCase();
                if (EXIT.equals(choice)) {
                    move = EXIT;
                    break;
                }
                if (validMoves.contains(choice)) {
                    move = choice;
                    break;
                } else {
                    log.info("Re-Enter correct choice.");
                }
            }
        } catch (Exception e) {
            log.error("Error while reading input from command line", e);
        }
        return move;
    }
}
