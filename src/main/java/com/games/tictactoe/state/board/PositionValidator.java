package com.games.tictactoe.state.board;

@FunctionalInterface
public interface PositionValidator {
    boolean isValid(int pos);
}
