package com.games.tictactoe.board;

import com.games.tictactoe.player.PlayerType;

/**
 * Should know to go from 1, 2, 3 => (0, 0), (0, 1), (0, 2)
 */
public interface TicTacToeBoard {
    public enum WinConfig {
        DRAW, WIN, NONE
    }
    public String getPosDescription(int pos);
    public boolean setMove(int move, PlayerType playerType);
    public String toString();
    public WinConfig isWinningConfig();
}
