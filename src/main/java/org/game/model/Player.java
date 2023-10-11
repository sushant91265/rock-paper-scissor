package org.game.model;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Player {
    private final String name;
    private final MoveGenerator moveGenerator;

    public Player(String name, MoveGenerator moveGenerator) {
        this.name = name;
        this.moveGenerator = moveGenerator;
    }

    public String getMove() {
        var move = this.moveGenerator.generateMove();
        log.info("Player {} move: {}", this.name, move);
        return move;
    }
}
