package org.game.model;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class RandomMoveGenerator implements MoveGenerator {

    private List<String> possibleMoves = new ArrayList<>();

    public RandomMoveGenerator(List<String> possibleMoves) {
        this.possibleMoves = possibleMoves;
    }

    @Override
    public String generateMove() {
        int randomIndex = (int) (Math.random() * possibleMoves.size());
        return possibleMoves.get(randomIndex);
    }
}
