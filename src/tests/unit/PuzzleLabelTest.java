package tests.unit;

import main.*;
import main.model.Position;
import main.model.puzzle.Puzzle;
import main.model.puzzle.PuzzleFactory;
import main.model.puzzle.PuzzleType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PuzzleLabelTest {

    @Test
    public void moveCountIncreasesAfterValidMove() {
        Puzzle testPuzzle = PuzzleFactory.getInstance(PuzzleType.COMPLETE);

        GameBoard gameBoard = new GameBoard(testPuzzle);
        gameBoard.handleMove(new Position(1, 2));

        assertEquals(1, MoveCounter.getValue());
    }

    @Test
    public void moveCountDoesntIncreaseAfterInvalidMove() {
        Puzzle testPuzzle = PuzzleFactory.getInstance(PuzzleType.COMPLETE);

        GameBoard gameBoard = new GameBoard(testPuzzle);
        gameBoard.handleMove(new Position(1, 1));

        assertEquals(0, MoveCounter.getValue());
    }
}