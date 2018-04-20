package com.games.tictactoe.player.humanplayer;

import com.games.tictactoe.board.PositionValidator;
import com.games.tictactoe.player.PlayerType;
import com.games.tictactoe.player.TicTacToePlayer;

import java.util.Optional;
import java.util.function.Supplier;

public class HumanPlayer extends TicTacToePlayer {
    private final PositionValidator positionValidator;
    private final Supplier<String> moveReader;
    private final Supplier<String> nameReader;

    public HumanPlayer(PlayerType playerType,
                       PositionValidator positionValidator,
                       Supplier<String> nameReader,
                       Supplier<String> moveReader ) {
        super(nameReader, playerType);
        this.positionValidator = positionValidator;
        this.moveReader = moveReader;
        this.nameReader = nameReader;
    }

    @Override
    public Optional<Integer> move() {
        return getMove(moveReader, positionValidator) ;
    }

    private Optional<Integer> getMove(Supplier<String> moveReader, PositionValidator positionValidator) {
        return toInt(moveReader.get())
                .filter(i -> positionValidator.isValid(i));
    }

    private Optional<Integer> toInt(String maybeInt) {
        if (isInteger(maybeInt)) {
            return Optional.of(Integer.parseInt(maybeInt));
        } else {
            return Optional.empty();
        }
    }
    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
