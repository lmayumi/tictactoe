package com.games.tictactoe.board.standardgrid;

import java.util.Optional;

public class Grid3X3<T> implements Grid<T> {
    protected static final int N = 3;
    protected T[][] board;

    public Grid3X3() {
        this.board = (T[][])new Object[N][N];
    }

    @Override
    public int rowLength() {
        return N;
    }

    @Override
    public int columnLength() {
        return N;
    }

    @Override
    public void set(int row, int col, T elem) {
        board[row][col] = elem;
    }

    @Override
    public Optional<T> get(int row, int col) {
        T elem = board[row][col];
        if (elem == null) {
            return Optional.empty();
        } else {
            return Optional.of(elem);
        }
    }
}
