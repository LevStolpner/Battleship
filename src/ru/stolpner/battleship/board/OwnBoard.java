package ru.stolpner.battleship.board;

import ru.stolpner.battleship.Ship;
import ru.stolpner.battleship.cell.OwnBoardCell;
import ru.stolpner.battleship.util.Rotation;

import java.util.Arrays;
import java.util.Objects;

import static ru.stolpner.battleship.util.Constants.BOARD_SIZE;
import static ru.stolpner.battleship.util.Constants.MAX_NUMBER_OF_SHIPS;

public class OwnBoard {
    private OwnBoardCell[][] cells;
    private Ship[] ships;

    public OwnBoard() {
        initialize();
    }

    public boolean canPlaceShip(int x, int y, int length, Rotation rotation) {
        return isPlacementInBounds(x, y, length, rotation)
                && isPlacementAvailable(x, y, length, rotation);
    }

    public void placeShip(int x, int y, int length, Rotation rotation) {
        Ship ship = new Ship(x, y, length, rotation);
        addShip(ship);
        setShipToCells(ship);
    }

    public String getRepresentation() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (cells[i][j].getShip().isPresent()) {
                    result.append("S ");
                } else {
                    result.append("E ");
                }
            }
            result.append("\n");
        }

        return result.toString();
    }

    private void initialize() {
        ships = new Ship[MAX_NUMBER_OF_SHIPS];
        cells = new OwnBoardCell[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                cells[i][j] = new OwnBoardCell(i, j);
            }
        }
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
                .filter(Objects::nonNull)
                .noneMatch(ship -> isPlaceOccupiedByShip(ship, x, y, length, rotation));
    }

    private boolean isPlaceOccupiedByShip(Ship ship, int x, int y, int length, Rotation rotation) {
        int shipLeftUpperCornerX = ship.getX() - 1;
        int shipLeftUpperCornerY = ship.getY() - 1;
        int shipRightBottomCornerX = ship.getX() + (ship.isVertical() ? 1 : ship.getLength());
        int shipRightBottomCornerY = ship.getY() + (ship.isVertical() ? ship.getLength() : 1);

        int newShipLeftUpperCornerX = x - 1;
        int newShipLeftUpperCornerY = y - 1;
        int newShipRightBottomCornerX = x + (rotation.isVertical() ? 1 : length);
        int newShipRightBottomCornerY = y + (rotation.isVertical() ? length : 1);

        return shipLeftUpperCornerX < newShipRightBottomCornerX && shipLeftUpperCornerY < newShipRightBottomCornerY &&
                shipRightBottomCornerX > newShipLeftUpperCornerX && shipRightBottomCornerY > newShipLeftUpperCornerY;
    }

    private void addShip(Ship ship) {
        for (int i = 0; i < ships.length; i++) {
            if (ships[i] == null) {
                ships[i] = ship;
                break;
            }
        }
    }

    private void setShipToCells(Ship ship) {
        switch (ship.getRotation()) {
            case VERTICAL:
                for (int i = ship.getY(); i < ship.getY() + ship.getLength(); i++) {
                    cells[ship.getX()][i].setShip(ship);
                }
                break;
            case HORIZONTAL:
                for (int i = ship.getX(); i < ship.getX() + ship.getLength(); i++) {
                    cells[i][ship.getY()].setShip(ship);
                }
        }
    }
}
