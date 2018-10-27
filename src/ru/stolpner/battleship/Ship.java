package ru.stolpner.battleship;

import ru.stolpner.battleship.util.Rotation;

public class Ship {
    private int x;
    private int y;
    private int length;
    private Rotation rotation;

    public Ship(int x, int y, int length, Rotation rotation) {
        this.x = x;
        this.y = y;
        this.length = length;
        this.rotation = rotation;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLength() {
        return length;
    }

    public Rotation getRotation() {
        return rotation;
    }

    public boolean isVertical() {
        return rotation == Rotation.VERTICAL;
    }
}
