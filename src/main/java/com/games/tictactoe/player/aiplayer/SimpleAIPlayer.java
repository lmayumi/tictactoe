package com.games.tictactoe.player.aiplayer;

import com.games.tictactoe.player.PlayerType;
import com.games.tictactoe.player.TicTacToePlayer;

import java.util.Optional;
import java.util.function.Supplier;

public class SimpleAIPlayer extends TicTacToePlayer {
    private final Supplier<Optional<Integer>> posSupplier;

    public SimpleAIPlayer(PlayerType playerType, Supplier<Optional<Integer>> posSupplier) {
        super(() -> "AI", playerType);
        this.posSupplier = posSupplier;
    }


    @Override
    public Optional<Integer> move() {
        return posSupplier.get();
    }
}
