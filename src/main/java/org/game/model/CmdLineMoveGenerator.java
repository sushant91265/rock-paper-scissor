package org.game.model;

import lombok.NoArgsConstructor;
import org.game.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

@NoArgsConstructor
public class CmdLineMoveGenerator implements MoveGenerator {
    private static final Logger log = LoggerFactory.getLogger(CmdLineMoveGenerator.class);

    private List<String> validMoves;

    public CmdLineMoveGenerator(List<String> validMoves) {
        this.validMoves = validMoves;
    }

    @Override
    public String generateMove() {
        String move = "";
        try {
            Scanner scanner = Main.ScannerSingleton.getScanner();
            while(true) {
                log.info("Enter your move. Valid moves " + validMoves);
                String choice = scanner.nextLine().trim().toLowerCase();
                if (choice.equals("exit")) {
                    move = "exit";
                    break;
                }
                if (validMoves.contains(choice)) {
                    move = choice;
                    break;
                } else {
                    log.info("Enter correct choice");
                }
            }
        } catch (Exception e) {
            log.error("Error while reading input from command line", e);
        }
        return move;
    }
}
