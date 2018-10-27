package ru.stolpner.battleship.board;

import ru.stolpner.battleship.Ship;
import ru.stolpner.battleship.cell.OwnBoardCell;
import ru.stolpner.battleship.util.Rotation;

import java.util.Arrays;

import static ru.stolpner.battleship.util.Constants.BOARD_SIZE;
import static ru.stolpner.battleship.util.Constants.MAX_NUMBER_OF_SHIPS;

public class OwnBoard {
    OwnBoardCell[][] cells;
    Ship[] ships;

    public OwnBoard() {
        initialize();
    }

    public boolean canPlaceShip(int x, int y, int length, Rotation rotation) {
        return isPlacementInBounds(x, y, length, rotation)
                && isPlacementAvailable(x, y, length, rotation);
    }

    public void placeShip(int x, int y, int length, Rotation rotation) {

    }

    private boolean isPlacementInBounds(int x, int y, int length, Rotation rotation) {
        switch (rotation) {
            case VERTICAL:
                return y + length <= BOARD_SIZE;
            default:
                return x + length <= BOARD_SIZE;
        }
    }

    private boolean isPlacementAvailable(int x, int y, int length, Rotation rotation) {
        return Arrays.stream(ships)
                .noneMatch(ship -> isPlaceOccupiedByShip(ship, x, y, length, rotation));
    }

    private boolean isPlaceOccupiedByShip(Ship ship, int x, int y, int length, Rotation rotation) {
        int shipLeftUpperCornerX = ship.getPositionX() - 1;
        int shipLeftUpperCornerY = ship.getPositionY() - 1;
        int shipRightBottomCornerX = ship.getPositionX() + (ship.isVertical() ? 1 : ship.getLength());
        int shipRightBottomCornerY = ship.getPositionY() + (ship.isVertical() ? ship.getLength() : 1);

        int newShipLeftUpperCornerX = x - 1;
        int newShipLeftUpperCornerY = y - 1;
        int newShipRightBottomCornerX = x + (rotation.isVertical() ? 1 : length);
        int newShipRightBottomCornerY = y + (rotation.isVertical() ? length : 1);

        return shipLeftUpperCornerX < newShipRightBottomCornerX && shipLeftUpperCornerY < newShipRightBottomCornerY &&
                shipRightBottomCornerX > newShipLeftUpperCornerX && shipRightBottomCornerY > newShipLeftUpperCornerY;
    }

    private void initialize() {
        ships = new Ship[MAX_NUMBER_OF_SHIPS];
        cells = new OwnBoardCell[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                cells[i][j] = new OwnBoardCell();
            }
        }
    }
}
