package ru.stolpner.battleship.board;

import ru.stolpner.battleship.cell.EnemyBoardCell;

import static ru.stolpner.battleship.util.Constants.BOARD_SIZE;

public class EnemyBoard {
   private EnemyBoardCell[][] cells;

    public EnemyBoard() {
        initialize();
    }

    private void initialize() {
        cells = new EnemyBoardCell[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                cells[i][j] = new EnemyBoardCell(i, j);
            }
        }
    }
}
