import java.util.ArrayList;
import java.util.List;

public class Board
{
    private static final int ROW_LENGTH = 3;
    private static final int COLUMN_LENGTH = 3;

    private List<Tile> _plays = new ArrayList<>();

    public Board()
    {
        for (int i = 0; i < ROW_LENGTH; i++)
        {
            for (int j = 0; j < COLUMN_LENGTH; j++)
            {
                // Feature envy
                Tile tile = new Tile();
                tile.X = i;
                tile.Y = j;
                tile.Symbol = Tile.SYMBOL_EMPTY;
                _plays.add(tile);
            }
        }
    }


    public char SymbolAt(int x, int y) {
        return TileAt(x, y).Symbol;
    }
    public Tile TileAt(int x, int y)
    {
        for (Tile t : _plays) {
            if (t.X == x && t.Y == y){
                return t;
            }
        }
        return null;
    }

    public void AddTileAt(char symbol, int x, int y)
    {
        TileAt(x,y).Symbol = symbol;
    }
}