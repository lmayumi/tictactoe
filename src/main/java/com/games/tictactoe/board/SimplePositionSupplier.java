package com.games.tictactoe.board;

import java.util.Optional;

public interface SimplePositionSupplier {
    public Optional<Integer> getNext();
}
