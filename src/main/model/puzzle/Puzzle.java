package main.model.puzzle;

import main.GameBoard;
import main.model.Position;

import java.util.Arrays;

public class Puzzle {
    private PuzzlePiece[][] puzzle = new PuzzlePiece[GameBoard.ROW_COUNT][GameBoard.COL_COUNT];
    private EmptyPiece emptyPiece;

    public Puzzle() {
        this.create();

        this.emptyPiece = new EmptyPiece(new Position(GameBoard.ROW_COUNT - 1, GameBoard.COL_COUNT - 1));
        this.puzzle[GameBoard.ROW_COUNT - 1][GameBoard.COL_COUNT - 1] = this.emptyPiece;
    }

    private void create() {
        for (int row = 0; row < GameBoard.ROW_COUNT; row++) {
            for (int col = 0; col < GameBoard.COL_COUNT; col++) {
                this.puzzle[row][col] = new PuzzlePiece(new Position(row, col), "" + (row*GameBoard.COL_COUNT+col+1));
            }
        }
    }

    public PuzzlePiece[][] getPuzzle() {
        return puzzle;
    }

    public EmptyPiece getEmptyPiece() {
        return emptyPiece;
    }

    public boolean isPuzzleComplete() {
        for (int row = 0; row < GameBoard.ROW_COUNT; row++) {
            for (PuzzlePiece piece : this.puzzle[row]) {
                if (piece != this.emptyPiece && !piece.isInFinalPosition()) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public String toString() {
        return "Puzzle{" +
                "puzzle=" + Arrays.toString(puzzle) +
                ", emptyPiece=" + emptyPiece +
                '}';
    }
}
