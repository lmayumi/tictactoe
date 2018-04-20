package com.games.tictactoe.player;

import java.util.Optional;
import java.util.function.Supplier;

public abstract class TicTacToePlayer implements MoveMethod {
    private final PlayerType playerType;
    private final Supplier<String> nameSupplier;

    public TicTacToePlayer(Supplier<String> nameSupplier, PlayerType playerType) {
        this.nameSupplier = nameSupplier;
        this.playerType = playerType;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public String getName() {
        return nameSupplier.get();
    }

    @Override
    public abstract Optional<Integer> move();
}
