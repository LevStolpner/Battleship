package ru.stolpner.battleship.player;

import ru.stolpner.battleship.board.EnemyBoard;
import ru.stolpner.battleship.board.OwnBoard;
import ru.stolpner.battleship.util.Rotation;

import static ru.stolpner.battleship.util.Constants.BOARD_SIZE;
import static ru.stolpner.battleship.util.Constants.NUMBER_OF_SHIPS_BY_LENGTH;
import static ru.stolpner.battleship.util.Constants.SHIP_MAX_LENGTH;
import static ru.stolpner.battleship.util.Constants.SHIP_MIN_LENGTH;

public abstract class Player {
    OwnBoard ownBoard;
    EnemyBoard enemyBoard;

    public Player() {
        this.ownBoard = new OwnBoard();
        this.enemyBoard = new EnemyBoard();
    }

    public void placeShips() {
        for (int shipLength = SHIP_MAX_LENGTH; shipLength >= SHIP_MIN_LENGTH; shipLength--) {
            int numberOfShipsWithSelectedLengthPlaced = 0;
            while (numberOfShipsWithSelectedLengthPlaced < NUMBER_OF_SHIPS_BY_LENGTH.get(shipLength)) {
                int shipPositionX = getRandomPosition();
                int shipPositionY = getRandomPosition();
                Rotation shipRotation = getRandomRotation();
                if (ownBoard.canPlaceShip(shipPositionX, shipPositionY, shipLength, shipRotation)) {
                    ownBoard.placeShip(shipPositionX, shipPositionY, shipLength, shipRotation);
                    numberOfShipsWithSelectedLengthPlaced++;
                }
            }
        }
    }

    private int getRandomPosition() {
        return (int) (Math.random() * BOARD_SIZE);
    }

    private Rotation getRandomRotation() {
        return Math.random() < 0.5 ? Rotation.VERTICAL : Rotation.HORIZONTAL;
    }
}
