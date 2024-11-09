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
        // Feature envy on accede a _board.....Symbol
        //if the positions in first row are taken
        // Message chain
        if (_board.isNotSymbolEmpty(0, 0) && _board.isNotSymbolEmpty(0, 1) && _board.isNotSymbolEmpty(0, 2)) {
            //if first row is full with same symbol
            if (_board.TileAt(0, 0).Symbol ==
                    _board.TileAt(0, 1).Symbol &&
                    _board.TileAt(0, 2).Symbol == _board.TileAt(0, 1).Symbol) {
                return _board.TileAt(0, 0).Symbol;
            }
        }

        //if the positions in first row are taken
        if (_board.isNotSymbolEmpty(1, 0) &&
                _board.isNotSymbolEmpty(1, 1) &&
                _board.isNotSymbolEmpty(1, 2)) {
            //if middle row is full with same symbol
            if (_board.TileAt(1, 0).Symbol ==
                    _board.TileAt(1, 1).Symbol &&
                    _board.TileAt(1, 2).Symbol ==
                            _board.TileAt(1, 1).Symbol) {
                return _board.TileAt(1, 0).Symbol;
            }
        }

        //if the positions in first row are taken
        if (_board.isNotSymbolEmpty(2, 0) &&
                _board.isNotSymbolEmpty(2, 1) &&
                _board.isNotSymbolEmpty(2, 2)) {
            //if middle row is full with same symbol
            if (_board.TileAt(2, 0).Symbol ==
                    _board.TileAt(2, 1).Symbol &&
                    _board.TileAt(2, 2).Symbol ==
                            _board.TileAt(2, 1).Symbol) {
                return _board.TileAt(2, 0).Symbol;
            }
        }

        return Tile.SYMBOL_EMPTY;
    }
}

