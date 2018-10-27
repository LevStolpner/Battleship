package ru.stolpner.battleship.cell;

public class EnemyBoardCell {
    private int x;
    private int y;
    private boolean isShot;
    private boolean isHit;

    public EnemyBoardCell(int x, int y) {
        this.x = x;
        this.y = y;
        this.isShot = false;
        this.isHit = false;
    }

    public boolean isShot() {
        return isShot;
    }

    public boolean isHit() {
        return isHit;
    }
}
