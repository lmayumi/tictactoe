package com.games.tictactoe.runner;

public interface GameMessageCallback {
    public void reportWelcomeMessage();
    public void reportInstructions(String gameStatus);
    public void reportStatus(String movePlayer1, String movePlayer2);
    public void reportPlayer2Win(boolean isWin, boolean isDraw, String gameStatus);
    public void reportPlayer1Win(boolean isWin, boolean isDraw, String gameStatus);
    public void moveError();
    public void getMove();
}
