public class Game {
    // Symbol
    private char _lastSymbol = Tile.SYMBOL_EMPTY;
    private Board _board = new Board();

    public void Play(char symbol, int x, int y) throws Exception {
        //if first move
        if (_lastSymbol == Tile.SYMBOL_EMPTY) {
            //if player is X
            if (symbol == Tile.SYMBOL_O) {
                throw new Exception("Invalid first player");
            }
        }
        //if not first move but player repeated
        else if (symbol == _lastSymbol) {
            throw new Exception("Invalid next player");
        }
        //if not first move but play on an already played tile
        else if (_board.isNotSymbolEmpty(x, y)) {
            throw new Exception("Invalid position");
        }

        // update game state
        _lastSymbol = symbol;
        _board.AddTileAt(symbol, x, y);
    }

    public char Winner() {
        Character winnerSymbol = _board.getWinnerForRawCompleted();
        if (winnerSymbol != null) return winnerSymbol;

        // Feature envy on accede a _board.....Symbol
        return Tile.SYMBOL_EMPTY;
    }

}

