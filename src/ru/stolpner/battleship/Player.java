package ru.stolpner.battleship;

public class Player {

    private final OwnBoard ownBoard;
    private final EnemyBoard enemyBoard;

    public Player() {
        this.ownBoard = new OwnBoard();
        this.enemyBoard = new EnemyBoard();
    }
}
