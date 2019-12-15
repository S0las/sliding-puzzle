package tests.unit;

import main.model.Position;
import main.model.puzzle.Puzzle;
import main.model.puzzle.PuzzleFactory;
import main.model.puzzle.PuzzleType;
import main.service.PuzzleMover;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PuzzleMoveTest {

    @Test
    public void puzzlePiecesSwapAfterValidMove() {
        Puzzle testPuzzle = PuzzleFactory.getInstance(PuzzleType.COMPLETE);

        PuzzleMover puzzleMover = new PuzzleMover(testPuzzle);
        puzzleMover.move(new Position(1, 2));

        assertFalse(testPuzzle.isPuzzleComplete());
    }

    @Test
    public void puzzleDoesntChangeOnInvalidMove() {
        Puzzle testPuzzle = PuzzleFactory.getInstance(PuzzleType.COMPLETE);

        PuzzleMover puzzleMover = new PuzzleMover(testPuzzle);
        puzzleMover.move(new Position(1, 1));

        assertTrue(testPuzzle.isPuzzleComplete());
    }
}