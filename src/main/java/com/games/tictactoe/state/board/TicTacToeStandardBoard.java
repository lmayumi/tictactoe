package com.games.tictactoe.state.board;

import com.games.tictactoe.state.grid.Grid3X3;
import com.games.tictactoe.player.PlayerType;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TicTacToeStandardBoard implements TicTacToeBoard, SimplePositionSupplier, PositionValidator {
    protected static final int N = 3;
    private final Grid3X3<PlayerType> grid;

    public TicTacToeStandardBoard(Grid3X3<PlayerType> grid) {
        this.grid = grid;
    }
    
    @Override
    public String getPosDescription(int pos) {
        String str = "";
        if (pos == 5) {
            str = "center";
            return str;
        }

        if ((pos - 1) / N == 0) {
            str += "upper ";
        } else if ((pos - 1) / N == 1) {
            str += "middle ";
        } else
            str += "lower ";

        if ((pos - 1) % N == 0)
            str += "left";
        else if ((pos - 1) % N == 1)
            str += "middle";
        else
            str += "right";

        return str;
    }

    @Override
    public boolean setMove(int move, PlayerType playerType) {
        int row = positionToRow(move);
        int col = positionToColumn(move);

        Optional<PlayerType> maybePlayerType = grid.get(row, col);

        if (!maybePlayerType.isPresent()) {
            grid.set(row, col, playerType);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public WinConfig isWinningConfig() {
        if (checkRow() || checkColumn() || checkDiagonalLeft() || checkDiagonalRight()) {
            return WinConfig.WIN;
        } else if (isDraw()) {
            return WinConfig.DRAW;
        } else {
            return WinConfig.NONE;
        }
    }

    private boolean isDraw() {
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                if (isAvailable(i, j))
                    return false;
            }
            return true;
    }

    private boolean checkDiagonalRight() {
        return isWin(grid.get(0,0), grid.get(1, 1), grid.get(2, 2));
    }

    private boolean checkDiagonalLeft() {
        return isWin(grid.get(2,0), grid.get(1, 1), grid.get(0, 2));
    }

    private boolean checkRow() {
        for (int row = 0; row < N; row++) {
            boolean maybeWin =
                    isWin(grid.get(row,0), grid.get(row, 1), grid.get(row, 2));

            if (maybeWin) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumn() {
        for (int col = 0; col < N; col++) {
            boolean maybeWin =
                    isWin(grid.get(0,col), grid.get(1, col), grid.get(2, col));

            if (maybeWin) {
                return true;
            }
        }
        return false;
    }

    private boolean isWin(Optional<PlayerType>... maybePlayerTypes) {
        List<PlayerType> playerTypes = Stream.of(maybePlayerTypes)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        if (playerTypes.size() == 3 && playerTypes.stream().distinct().count() == 1) {
            return true;
        } else {
            return false;
        }
    }

    private int positionToRow(int pos) {
        return (pos - 1) / N;
    }

    private int positionToColumn(int pos) {
        return (pos - 1) % N;
    }

    private boolean isAvailable(int row, int col) {
        return !grid.get(row, col).isPresent();
    }

    @Override
    public Optional<Integer> getNext() {
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                if (!grid.get(i, j).isPresent())
                    return Optional.of((i * 3 + j + 1));
            }
            return Optional.empty();
    }

    @Override
    public boolean isValid(int pos) {
        int row = positionToRow(pos);
        int col = positionToColumn(pos);
        return pos > 0 && pos < 10 && isAvailable(row, col);
    }
}
