package ru.stolpner.battleship;

public class EnemyBoard {

    private final CellState[][] board = new CellState[10][10];

    public EnemyBoard() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = CellState.EMPTY;
            }
        }
    }

    public char[][] getInfo() {
        char[][] result = new char[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                result[i][j] = board[i][j].getSymbol();
            }
        }

        return result;
    }
}
