package ru.stolpner.battleship;

import ru.stolpner.battleship.util.Rotation;

public class Ship {
    private int positionX;
    private int positionY;
    private int length;
    private Rotation rotation;

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
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
