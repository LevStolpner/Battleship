package ru.stolpner.battleship;

public class Cell {

    private Ship ship;
    private boolean isHit;

    public Cell() {
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public void shoot() {
        this.isHit = true;
    }

    public boolean isHit() {
        return this.isHit;
    }

    public boolean isNotHit() {
        return !this.isHit;
    }

    public boolean hasShip() {
        return ship != null;
    }

    public boolean hasNoShip() {
        return ship == null;
    }
}
