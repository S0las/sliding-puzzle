package main.service;

import main.GameBoard;
import main.model.Position;
import main.model.puzzle.Puzzle;

import java.util.Random;

public class PuzzleShuffler {
    private static final int SHUFFLE_ITERATION_COUNT = 1000;
    private Puzzle puzzle;
    private PuzzleMover puzzleMover;
    private Puzzle originalPuzzle;

    public PuzzleShuffler(Puzzle puzzle) {
        this.puzzle = puzzle;
        this.originalPuzzle = puzzle;
        this.puzzleMover = new PuzzleMover(this.puzzle);
        this.shuffle();
    }

    private void shuffle() {
        Random random = new Random();

        for (int i = 0; i < SHUFFLE_ITERATION_COUNT; i++) {
            int randomRow = random.nextInt(GameBoard.ROW_COUNT);
            int randomCol = random.nextInt(GameBoard.COL_COUNT);

            if (this.puzzleMover.isMoveValid(new Position(randomRow, randomCol))) {
                this.puzzleMover.move(new Position(randomRow, randomCol));
            }
        }

        if (this.isPuzzleShuffled()) {
            this.shuffle();
        }
    }

    private boolean isPuzzleShuffled() {
        return this.puzzle != this.originalPuzzle;
    }

    public Puzzle getPuzzle() {
        return this.puzzle;
    }
}
