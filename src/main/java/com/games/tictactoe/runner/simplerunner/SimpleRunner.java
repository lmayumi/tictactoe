package com.games.tictactoe.runner.simplerunner;

import com.games.tictactoe.game.TicTacToeGame;
import com.games.tictactoe.player.TicTacToePlayer;
import com.games.tictactoe.runner.GameMessageCallback;
import com.games.tictactoe.runner.TicTacToeRunner;

import java.util.Optional;

public class SimpleRunner implements TicTacToeRunner {
    public void runGame(TicTacToeGame game, GameMessageCallback callback) {
        callback.reportWelcomeMessage();
        callback.reportInstructions(game.toString());

        while (game.notGameOver()) {
            int movePlayer1 = getUntilValid(game.getplayer1(), callback::getMove, callback::moveError);
            game.setMove(movePlayer1, game.getplayer1().getPlayerType());

            if (game.isGameOver()) {
                callback.reportPlayer1Win(game.isWin(), game.isDraw(), game.toString());
                return;
            }

            int movePlayer2 = getUntilValid(game.getplayer2(), callback::getMove, callback::moveError);
            game.setMove(movePlayer1, game.getplayer2().getPlayerType());

            callback.reportStatus(game.getPosDescription(movePlayer1), game.getPosDescription(movePlayer2));

            if (game.isGameOver()) {
                callback.reportPlayer2Win(game.isWin(), game.isDraw(), game.toString());
                return;
            }
        }
    }
    private int getUntilValid(TicTacToePlayer player, Runnable getInputMessage, Runnable errorReport) {
        getInputMessage.run();
        Optional<Integer> playerMove = player.move();
        while (!playerMove.isPresent()) {
            errorReport.run();
            getInputMessage.run();
            playerMove = player.move();
        }
        return playerMove.get();
    }
}