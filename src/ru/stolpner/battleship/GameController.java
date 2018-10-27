package ru.stolpner.battleship;

import ru.stolpner.battleship.player.Bot;
import ru.stolpner.battleship.player.Human;
import ru.stolpner.battleship.util.Printer;

public class GameController {
    private Human human;
    private Bot bot;

    public GameController() {
        this.human = new Human();
        this.bot = new Bot();
    }

    public void startGame() {
        prepareShips();
        startShooting();
    }

    private void prepareShips() {
        Printer.printLine("Starting the game...");
        bot.placeShips();
        Printer.printLine("I've placed my ships, your turn.");
        human.placeShips();
        Printer.printLine("OK, we are ready.");
    }

    private void startShooting() {
        Printer.printLine("Time to shoot! You first.");
        //TODO add shooting stage logic here
    }
}
