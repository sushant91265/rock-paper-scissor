package org.game.model;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class represents a random move generator for the computer player.
 */
@NoArgsConstructor
public class RandomMoveGenerator implements MoveGenerator {

    private List<String> possibleMoves = new ArrayList<>();
    private Random random;

    public RandomMoveGenerator(List<String> possibleMoves) {
        this.possibleMoves = possibleMoves;
        this.random = new Random();
    }

    @Override
    public String generateMove() {
        int randomIndex = random.nextInt(this.possibleMoves.size());
        return this.possibleMoves.get(randomIndex);
    }
}
