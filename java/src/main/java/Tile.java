
public class Tile
{
    // X, Y -> Position
    // Devrait etre dans Board
    public int X;
    public int Y;
    // enum
    public char Symbol;
}

record Position(int x, int y) {}