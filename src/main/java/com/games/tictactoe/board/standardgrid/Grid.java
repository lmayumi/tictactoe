package com.games.tictactoe.board.standardgrid;

import java.util.Optional;

public interface Grid<T> {
    int rowLength();
    int columnLength();
    void set(int row, int col, T elem);
    Optional<T> get(int row, int col);
}
