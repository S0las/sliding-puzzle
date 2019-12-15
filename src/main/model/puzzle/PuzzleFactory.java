package main.model.puzzle;

import main.service.PuzzleShuffler;

import java.util.NoSuchElementException;

public class PuzzleFactory {

    private PuzzleFactory() { }

    public static Puzzle getInstance(PuzzleType puzzleType) {
        switch(puzzleType) {
            case SHUFFLED:
                return new PuzzleShuffler(new Puzzle()).getPuzzle();
            case COMPLETE:
                return new Puzzle();
            default:
                throw new NoSuchElementException(getNoSuchElementMessage(puzzleType.toString()));
        }
    }

    private static String getNoSuchElementMessage(String type) {
        return "\"" + type + "\"" + " does not exist.";
    }
}
