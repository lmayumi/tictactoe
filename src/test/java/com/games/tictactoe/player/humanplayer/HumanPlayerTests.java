package com.games.tictactoe.player.humanplayer;

import com.games.tictactoe.board.PositionValidator;
import com.games.tictactoe.player.PlayerType;
import com.games.tictactoe.player.TicTacToePlayer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;
import java.util.function.Supplier;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class HumanPlayerTests {

    @Test
    public void createHumanPlayerForValidIntegerMove() {
        // Given
        PlayerType playerType = PlayerType.O;
        PositionValidator validator = move -> true;
        Supplier<String> moveReader = () -> "1";
        Supplier<String> nameReader = () -> "name";

        // When
        TicTacToePlayer player = new HumanPlayer(playerType, validator, nameReader, moveReader);

        // Then
        assertEquals(player.getName(), "name");
        assertEquals(player.getPlayerType(), PlayerType.O);
        assert(player.move().get() == 1);
    }

    @Test
    public void createHumanPlayerForValidNonIntegerMove() {
        // Given
        PlayerType playerType = PlayerType.O;
        PositionValidator validator = move -> true;
        Supplier<String> moveReader = () -> "num";
        Supplier<String> nameReader = () -> "name";

        // When
        TicTacToePlayer player = new HumanPlayer(playerType, validator, nameReader, moveReader);

        // Then
        assertEquals(player.getName(), "name");
        assertEquals(player.getPlayerType(), PlayerType.O);
        assertEquals(player.move(), Optional.empty());
    }

    @Test
    public void createHumanPlayerForInvalidIntegerMove() {
        // Given
        PlayerType playerType = PlayerType.O;
        PositionValidator validator = move -> false;
        Supplier<String> moveReader = () -> "1";
        Supplier<String> nameReader = () -> "name";

        // When
        TicTacToePlayer player = new HumanPlayer(playerType, validator, nameReader, moveReader);

        // Then
        assertEquals(player.getName(), "name");
        assertEquals(player.getPlayerType(), PlayerType.O);
        assertEquals(player.move().get(), Optional.empty());
    }
}