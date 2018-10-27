package ru.stolpner.battleship.board;

import ru.stolpner.battleship.Ship;
import ru.stolpner.battleship.cell.OwnBoardCell;
import ru.stolpner.battleship.util.Rotation;

import static ru.stolpner.battleship.util.Constants.BOARD_SIZE;

public class OwnBoard {
    OwnBoardCell[][] cells;
    Ship[] ships;

    public OwnBoard() {
        initializeCells();
    }

    public boolean canPlaceShip(int shipPositionX, int shipPositionY, int shipLength, Rotation shipRotation) {
        return true;
    }

    public void placeShip(int shipPositionX, int shipPositionY, int shipLength, Rotation shipRotation) {

    }

    private void initializeCells() {
        cells = new OwnBoardCell[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                cells[i][j] = new OwnBoardCell();
            }
        }
    }
}
