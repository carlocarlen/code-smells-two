import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {
    private Game game;

    @BeforeEach
    public void InitializeGame(){
        game = new Game();
    }

    @Test
    public void NotAllowPlayerOToPlayFirst() {
        assertThrows(Exception.class, () -> game.Play(Tile.SYMBOL_O, 0, 0));
    }

    @Test
    public void NotAllowPlayerXToPlayTwiceInARow() {
        assertThrows(Exception.class, () ->{
            game.Play(Tile.SYMBOL_X, 0, 0);
            game.Play(Tile.SYMBOL_X, 1, 0);
        });
    }

    @Test
    public void NotAllowPlayerToPlayInLastPlayedPosition() {
        assertThrows(Exception.class, () ->{
            game.Play(Tile.SYMBOL_X, 0, 0);
            game.Play(Tile.SYMBOL_O, 0, 0);
        });
    }

    @Test
    public void NotAllowPlayerToPlayInAnyPlayedPosition() {
        assertThrows(Exception.class, () ->{
            game.Play(Tile.SYMBOL_X, 0, 0);
            game.Play(Tile.SYMBOL_O, 1, 0);
            game.Play(Tile.SYMBOL_X, 0, 0);
        });
    }

    @Test
    public void DeclarePlayerXAsAWinnerIfThreeInTopRow() throws Exception
    {
        game.Play(Tile.SYMBOL_X, 0, 0);
        game.Play(Tile.SYMBOL_O, 1, 0);
        game.Play(Tile.SYMBOL_X, 0, 1);
        game.Play(Tile.SYMBOL_O, 1, 1);
        game.Play(Tile.SYMBOL_X, 0, 2);

        char winner = game.Winner();

        assertEquals(Tile.SYMBOL_X, winner);
    }

    @Test
    public void DeclarePlayerOAsAWinnerIfThreeInTopRow() throws Exception
    {
        game.Play(Tile.SYMBOL_X, 2, 2);
        game.Play(Tile.SYMBOL_O, 0, 0);
        game.Play(Tile.SYMBOL_X, 1, 0);
        game.Play(Tile.SYMBOL_O, 0, 1);
        game.Play(Tile.SYMBOL_X, 1, 1);
        game.Play(Tile.SYMBOL_O, 0, 2);

        char winner = game.Winner();

        assertEquals(Tile.SYMBOL_O, winner);
    }

    @Test
    public void DeclarePlayerXAsAWinnerIfThreeInMiddleRow() throws Exception
    {
        game.Play(Tile.SYMBOL_X, 1, 0);
        game.Play(Tile.SYMBOL_O, 0, 0);
        game.Play(Tile.SYMBOL_X, 1, 1);
        game.Play(Tile.SYMBOL_O, 0, 1);
        game.Play(Tile.SYMBOL_X, 1, 2);

        char winner = game.Winner();

        assertEquals(Tile.SYMBOL_X, winner);
    }

    @Test
    public void DeclarePlayerOAsAWinnerIfThreeInMiddleRow() throws Exception
    {
        game.Play(Tile.SYMBOL_X, 0, 0);
        game.Play(Tile.SYMBOL_O, 1, 0);
        game.Play(Tile.SYMBOL_X, 2, 0);
        game.Play(Tile.SYMBOL_O, 1, 1);
        game.Play(Tile.SYMBOL_X, 2, 1);
        game.Play(Tile.SYMBOL_O, 1, 2);

        char winner = game.Winner();

        assertEquals(Tile.SYMBOL_O, winner);
    }

    @Test
    public void DeclarePlayerXAsAWinnerIfThreeInBottomRow() throws Exception
    {
        game.Play(Tile.SYMBOL_X, 2, 0);
        game.Play(Tile.SYMBOL_O, 0, 0);
        game.Play(Tile.SYMBOL_X, 2, 1);
        game.Play(Tile.SYMBOL_O, 0, 1);
        game.Play(Tile.SYMBOL_X, 2, 2);

        char winner = game.Winner();

        assertEquals(Tile.SYMBOL_X, winner);
    }

    @Test
    public void DeclarePlayerOAsAWinnerIfThreeInBottomRow() throws Exception
    {
        game.Play(Tile.SYMBOL_X, 0, 0);
        game.Play(Tile.SYMBOL_O, 2, 0);
        game.Play(Tile.SYMBOL_X, 1, 0);
        game.Play(Tile.SYMBOL_O, 2, 1);
        game.Play(Tile.SYMBOL_X, 1, 1);
        game.Play(Tile.SYMBOL_O, 2, 2);

        char winner = game.Winner();

        assertEquals(Tile.SYMBOL_O, winner);
    }
}
