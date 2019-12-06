package game;

import java.util.Random;

public class PuzzleLogic {
    public static int ROW_COUNT = 3;
    public static int COL_COUNT = 3;

    PuzzlePiece[][] puzzle;

    PuzzlePiece emptyPiece;

    public PuzzleLogic() {
        this.puzzle = new PuzzlePiece[ROW_COUNT][COL_COUNT];

        this.createPuzzlePieces();
        this.shufflePuzzle();
    }

    private void createPuzzlePieces() {
        for (int row = 0; row < ROW_COUNT; row++) {
            for (int col = 0; col < COL_COUNT; col++) {
                this.puzzle[row][col] = new PuzzlePiece(row, col, "" + (row*COL_COUNT+col+1));
            }
        }

        this.puzzle[ROW_COUNT - 1][COL_COUNT - 1] = new PuzzlePiece(ROW_COUNT - 1, COL_COUNT - 1, null);
        this.emptyPiece = this.puzzle[ROW_COUNT - 1][COL_COUNT - 1];
    }

    private void shufflePuzzle() {
        Random random = new Random();

        for (int i = 0; i < 1000; i++) {
            int randomRow = random.nextInt(ROW_COUNT);
            int randomCol = random.nextInt(COL_COUNT);

            if (this.isMoveValid(randomRow, randomCol)) {
                this.move(randomRow, randomCol);
            }
        }

        if (this.isGameOver()) {
            this.shufflePuzzle();
        }
    }

    public boolean isMoveValid(int row, int col) {
        return isEmptySpace(row - 1, col)
                || isEmptySpace(row + 1, col)
                || isEmptySpace(row, col - 1)
                || isEmptySpace(row, col + 1);
    }

    private boolean isEmptySpace(int row, int col) {
        return row >= 0
                && row < ROW_COUNT
                && col >= 0
                && col < COL_COUNT
                && this.puzzle[row][col] == this.emptyPiece;
    }

    public PuzzlePiece getPiece(int row, int col) {
        return this.puzzle[row][col];
    }

    public void move(int row, int col) {
        this.swapPieces(row, col, this.emptyPiece.getRow(), this.emptyPiece.getCol());
    }

    private void swapPieces(int row1, int col1, int row2, int col2) {
        PuzzlePiece temp = this.puzzle[row1][col1];

        this.puzzle[row1][col1] = this.puzzle[row2][col2];
        this.puzzle[row1][col1].setRow(row1);
        this.puzzle[row1][col1].setCol(col1);

        this.puzzle[row2][col2] = temp;
        this.puzzle[row2][col2].setRow(row2);
        this.puzzle[row2][col2].setCol(col2);
    }

    public boolean isGameOver() {
        for (int row = 0; row < ROW_COUNT; row++) {
            for (PuzzlePiece piece : this.puzzle[row]) {
                if (piece != this.emptyPiece && !piece.isInFinalPosition()) {
                    return false;
                }
            }
        }

        return true;
    }
}
