package ru.stolpner.battleship;

import java.util.Scanner;

public class Battleship {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Printer printer = new Printer(System.out);
        printer.printLine("...");
        Thread.sleep(1000);
        printer.printLine("Welcome to Battleship!");
        Thread.sleep(1500);
        printer.printLine("I'm going to crush you.");

        AI aiPlayer = new AI();
        Player player = new Player();



    }
}
