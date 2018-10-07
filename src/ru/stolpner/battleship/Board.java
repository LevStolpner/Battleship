package ru.stolpner.battleship;

public abstract class Board {

    protected final String name;
    protected final Cell[][] board = new Cell[10][10];

    public Board(String name) {
        this.name = name;
    }

    public char[][] getPrintableBoard() {
        return board;
    }

    public
    //Hit - H, Miss - M, Kill - D, Empty and not shot - '~'
}
