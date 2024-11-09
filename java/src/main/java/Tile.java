
public class Tile
{
    public static final char SYMBOL_EMPTY = ' ';
    public static final char SYMBOL_O = 'O';
    public static final char SYMBOL_X = 'X';
    // X, Y -> Position
    // Devrait etre dans Board
    public int X;
    public int Y;
    // enum
    public char Symbol;
}

record Position(int x, int y) {}