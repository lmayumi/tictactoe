package com.games.tictactoe.state.board;

import java.util.Optional;

public interface SimplePositionSupplier {
    public Optional<Integer> getNext();
}
