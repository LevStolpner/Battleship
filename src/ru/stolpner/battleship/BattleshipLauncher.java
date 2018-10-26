package ru.stolpner.battleship;

import ru.stolpner.battleship.util.Printer;

import java.util.Scanner;

public class BattleshipLauncher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Printer printer = new Printer(System.out);

        Controller controller = new Controller();
    }
}
