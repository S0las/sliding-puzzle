package main;

public class MoveCounter {
    private static int MOVES = 0;

    private MoveCounter() { }

    public static int getValue() {
        return MOVES;
    }

    public static void increment() {
        MOVES++;
    }
}
