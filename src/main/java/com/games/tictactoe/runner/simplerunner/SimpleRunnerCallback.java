package com.games.tictactoe.runner.simplerunner;

import com.games.tictactoe.runner.GameMessageCallback;

public class SimpleRunnerCallback implements GameMessageCallback {

    @Override
    public void reportWelcomeMessage() {
        System.out.println("Welcome to Tic-Tac-Toe.");
        System.out.println("");
    }

    @Override
    public void reportInstructions(String gameStatus) {
        System.out.println("Please make your move selection by entering "
                + "a number 1-9 corresponding to the movement "
                + "key on the right.\n");
        System.out.println(gameStatus.toString());
    }

    @Override
    public void reportStatus(String movePlayer1, String movePlayer2) {
        System.out.println("");
        System.out.println("You have put an X in the " +
                movePlayer1 +
                ". I will put a O in the " +
                movePlayer2 + ".");
    }

    @Override
    public void reportPlayer2Win(boolean isWin, boolean isDraw, String gameStatus) {
        System.out.println("");
        System.out.println(gameStatus);
        System.out.println("I won. Thanks for playing.");
    }

    @Override
    public void reportPlayer1Win(boolean isWin, boolean isDraw, String gameStatus) {
        if (isWin) {
            System.out.println("");
            System.out.println(gameStatus);
            System.out.println("You have beaten my poor AI!");
        } else if (isDraw) {
            System.out.println("");
            System.out.println(gameStatus);
            System.out.println("Well played. It is a draw!");
        }
    }

    @Override
    public void moveError() {
        System.out.println("Invalid message, please retry");
        System.out.println("");
    }

    @Override
    public void getMove() {
        System.out.println("Where to?");
        System.out.println("");
    }
}
