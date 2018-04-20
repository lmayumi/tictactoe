package com.games.tictactoe.game;


import com.games.tictactoe.state.board.TicTacToeBoard;
import com.games.tictactoe.player.PlayerType;
import com.games.tictactoe.player.TicTacToePlayer;

public class TicTacToeGame {
    private final TicTacToeBoard gameBoard;
    private final TicTacToePlayer firstPlayer;
    private final TicTacToePlayer secondPlayer;
    private TicTacToeBoard.WinConfig winConfig = TicTacToeBoard.WinConfig.NONE;

    public TicTacToeGame(
            TicTacToeBoard gameBoard,
            TicTacToePlayer firstPlayer,
            TicTacToePlayer secondPlayer) {
        this.gameBoard = gameBoard;
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public TicTacToePlayer getplayer1() {
        return firstPlayer;
    }

    public TicTacToePlayer getplayer2() {
        return secondPlayer;
    }

    public boolean setMove(int move, PlayerType playerType) {
        boolean isValidMove = gameBoard.setMove(move, playerType);
        if (isValidMove) {
            updateWinningConfig();
        }
        return isValidMove;
    }

    private void updateWinningConfig() {
        if (isGameOver()) {
            return;
        }

        TicTacToeBoard.WinConfig currentConfig = gameBoard.isWinningConfig();

        if (currentConfig != TicTacToeBoard.WinConfig.NONE) {
            this.winConfig = currentConfig;
        }
    }

    public boolean isGameOver() {
        return winConfig != TicTacToeBoard.WinConfig.NONE;
    }

    public boolean notGameOver() {
        return !isGameOver();
    }

    public boolean isWin() {
        return winConfig == TicTacToeBoard.WinConfig.WIN;
    }

    public boolean isDraw() {
        return winConfig == TicTacToeBoard.WinConfig.DRAW;
    }

    public String getPosDescription(int pos) {
        return gameBoard.getPosDescription(pos);
    }

    public String toString() {
        return gameBoard.toString();
    }
}