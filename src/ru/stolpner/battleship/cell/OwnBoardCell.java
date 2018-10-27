package ru.stolpner.battleship.cell;

import ru.stolpner.battleship.Ship;

import java.util.Optional;

public class OwnBoardCell {
    private int x;
    private int y;
    private Ship ship;
    private boolean isShot;

    public OwnBoardCell(int x, int y) {
        this.x = x;
        this.y = y;
        this.ship = null;
        this.isShot = false;
    }

    public Optional<Ship> getShip() {
        return Optional.ofNullable(ship);
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }
}
