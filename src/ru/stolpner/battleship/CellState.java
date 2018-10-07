package ru.stolpner.battleship;

/**
 * Possible cell states
 */
public enum CellState {
    EMPTY('E'),
    MISS('M'),
    OCCUPIED('O'),
    HIT('H'),
    DEAD('D');

    private char symbol;

    CellState(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}
