package com.games.tictactoe.board;

@FunctionalInterface
public interface PositionValidator {
    boolean isValid(int pos);
}
