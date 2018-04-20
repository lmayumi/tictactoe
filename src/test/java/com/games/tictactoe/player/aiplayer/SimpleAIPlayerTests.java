package com.games.tictactoe.player.aiplayer;

import com.games.tictactoe.player.PlayerType;
import com.games.tictactoe.player.TicTacToePlayer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;
import java.util.function.Supplier;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class SimpleAIPlayerTests {

    @Test
    public void shouldGetMoveFromAIPlayer() {
        // Given
        PlayerType playerType = PlayerType.O;
        Supplier<Optional<Integer>> moveSupplier = () -> Optional.of(Integer.valueOf(1));
        TicTacToePlayer player = new SimpleAIPlayer(playerType, moveSupplier);

        // Then
        assert(player.move().isPresent() && player.move().get() == 1);
        assertEquals(player.getPlayerType(), PlayerType.O);
    }
}
