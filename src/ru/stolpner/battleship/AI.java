package ru.stolpner.battleship;

public class AI {

    private final OwnBoard ownBoard;
    private final EnemyBoard enemyBoard;

    public AI() {
        this.ownBoard = new OwnBoard();
        this.enemyBoard = new EnemyBoard();
    }
}
