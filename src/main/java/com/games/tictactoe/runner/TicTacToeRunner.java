package com.games.tictactoe.runner;

import com.games.tictactoe.game.TicTacToeGame;

public interface TicTacToeRunner {
    public void runGame(TicTacToeGame game, GameMessageCallback callback);
}
