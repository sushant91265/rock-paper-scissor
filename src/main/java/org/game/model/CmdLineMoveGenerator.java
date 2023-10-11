package org.game.model;

import lombok.extern.slf4j.Slf4j;
import org.game.util.GameUtility;
import org.game.util.ScannerSingleton;

import java.util.List;
import java.util.Scanner;

/**
 * This class implements the MoveGenerator interface and provides the implementation for generating move from command line.
 */
@Slf4j
public class CmdLineMoveGenerator implements MoveGenerator {
    private final List<String> validMoves;
    private static final String EXIT = "exit";

    public CmdLineMoveGenerator(List<String> validMoves) {
        this.validMoves = validMoves;
    }

    /**
     * This method reads the input from command line and validates it against the valid moves.
     * @return move
     */
    @Override
    public String generateMove() {
        String move = "";
        try {
            Scanner scanner = ScannerSingleton.getScanner();
            while(true) {
                log.info("Enter your move. Valid moves {}", validMoves);
                String choice = scanner.nextLine().trim().toLowerCase();
                if (EXIT.equals(choice)) {
                    log.info("Exiting the game.");
                    System.exit(0);
                }
                if (GameUtility.isValidInput(choice, validMoves)) {
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
