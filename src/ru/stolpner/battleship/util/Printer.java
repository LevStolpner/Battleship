package ru.stolpner.battleship.util;

import java.io.PrintStream;

public class Printer {

    private final PrintStream printStream;

    public Printer(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void printLine(String text) {
        printStream.println(text);
    }
}
