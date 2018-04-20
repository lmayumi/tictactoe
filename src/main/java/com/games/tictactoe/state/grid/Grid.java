package com.games.tictactoe.state.grid;

import java.util.Optional;

public interface Grid<T> {
    int rowLength();
    int columnLength();
    void set(int row, int col, T elem);
    Optional<T> get(int row, int col);
}
