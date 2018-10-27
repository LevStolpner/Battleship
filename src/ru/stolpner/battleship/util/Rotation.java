package ru.stolpner.battleship.util;

public enum Rotation {
    VERTICAL,
    HORIZONTAL;

    public boolean isVertical() {
        return this == VERTICAL;
    }
}
