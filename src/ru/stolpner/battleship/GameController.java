package ru.stolpner.battleship;

import ru.stolpner.battleship.player.Bot;
import ru.stolpner.battleship.player.Human;

public class GameController {
    private Human human;
    private Bot bot;

    public GameController() {
        this.human = new Human();
        this.bot = new Bot();
    }

    public void startGame() {
        bot.placeShips();
        human.placeShips();
    }
}
