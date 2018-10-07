package ru.stolpner.battleship;

import java.util.List;

public class OwnBoard {

    private final Cell[][] board = new Cell[10][10];
    private List<Ship> ships;
    private boolean isShip4Placed = false;
    private int ships3Placed = 0;
    private int ships2Placed = 0;
    private int ships1Placed = 0;

    public OwnBoard() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    public char[][] getInfo() {
        char[][] result = new char[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Cell cell = board[i][j];
                if (cell.isNotHit()) {
                    if (cell.hasShip()) {
                        result[i][j] = CellState.OCCUPIED.getSymbol();
                    } else {
                        result[i][j] = CellState.EMPTY.getSymbol();
                    }
                } else {
                    if (cell.hasNoShip()) {
                        result[i][j] = CellState.MISS.getSymbol();
                    } else if (cell.getShip().isAlive()) {
                        result[i][j] = CellState.HIT.getSymbol();
                    } else {
                        result[i][j] = CellState.DEAD.getSymbol();
                    }
                }
            }
        }

        return result;
    }

    public boolean placeShip4(Ship ship) {
        if (isShip4Placed) {
            return false;
        }
        if (checkShipCoordinates(ship) && isPlaceAvailable(ship)) {
            if (ship.isVertical()) {
                for (int i = ship.getY(); i < ship.getY() + ship.getLength(); i++) {
                    BoardCell cell = getCell(ship.getX(), i);
                    cell.setShip(ship);
                }
            } else {
                for (int i = ship.getX(); i < ship.getX() + ship.getLength(); i++) {
                    BoardCell cell = getCell(i, ship.getY());
                    cell.setShip(ship);
                }
            }

            shipsOfLengthPlaced.put(ship.getLength(), shipsOfLengthPlaced.get(ship.getLength()) + 1);
            ships.add(ship);
            if (ships.size() == 10) {
                shootingStage = true;
            }
            return true;
        }

        return false;
    }

    public boolean placeShip3() {

    }

    public boolean placeShip2() {

    }

    public boolean placeShip1() {

    }

    private boolean placeShip(Ship ship) {

    }

    private void autoPlaceShips() {
        int len = 4;
        int x = (int) (Math.random() * 10);
        int y = (int) (Math.random() * 10);
        boolean vert = Math.random() < 0.5;
        while (len > 0) {
            for (int j = 0; j <= 4 - len; j++) {
                while (!placeShip(new Ship(x, y, vert, len))) {
                    x = (int) (Math.random() * 10);
                    y = (int) (Math.random() * 10);
                    vert = Math.random() < 0.5;
                }
            }
            len--;
        }
    }

    private boolean checkShipCoordinates(Ship ship) {
        int x = ship.getX();
        int y = ship.getY();
        return !(x < 0 || y < 0) && (ship.isVertical() ? x < size && y + ship.getLength() <= size : y < size && x + ship.getLength() <= size);
    }

    private boolean isPlaceAvailable(Ship newShip) {
        if (ships == null) return true;
        for (Ship placedShip : ships) {
            if (checkShipOverlapping(newShip, placedShip)) return false;
        }
        return true;
    }

    private boolean checkShipOverlapping(Ship first, Ship second) {
        int[] firstBorders = first.getBoundaries();
        int[] secondBorders = second.getBoundaries();

        //checking overlapping of ships or areas around them
        return firstBorders[0] < secondBorders[2] && firstBorders[2] > secondBorders[0] &&
                firstBorders[1] < secondBorders[3] && firstBorders[3] > secondBorders[1];
    }
}
