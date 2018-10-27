package ru.stolpner.battleship.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Constants {
    public static final int BOARD_SIZE = 10;
    public static final int SHIP_MIN_LENGTH = 4;
    public static final int SHIP_MAX_LENGTH = 4;
    public static final Map<Integer, Integer> NUMBER_OF_SHIPS_BY_LENGTH;

    static {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(4, 1);
        map.put(3, 2);
        map.put(2, 3);
        map.put(1, 4);
        NUMBER_OF_SHIPS_BY_LENGTH = Collections.unmodifiableMap(map);
    }
}
