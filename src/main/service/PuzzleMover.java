package main.service;

import main.*;
import main.model.puzzle.EmptyPiece;
import main.model.Position;
import main.model.puzzle.PuzzlePiece;
import main.model.puzzle.Puzzle;

public class PuzzleMover {
    private PuzzlePiece[][] puzzle;
    private EmptyPiece emptyPiece;

    public PuzzleMover(Puzzle puzzle) {
        this.puzzle = puzzle.getPuzzle();
        this.emptyPiece = puzzle.getEmptyPiece();
    }

    private void swapPieces(Position piecePosition, Position emptyPiecePosition) {
        PuzzlePiece temp = this.puzzle[piecePosition.getRow()][piecePosition.getCol()];

        this.puzzle[piecePosition.getRow()][piecePosition.getCol()] = this.puzzle[emptyPiecePosition.getRow()][emptyPiecePosition.getCol()];
        this.puzzle[piecePosition.getRow()][piecePosition.getCol()].getPosition().setRow(piecePosition.getRow());
        this.puzzle[piecePosition.getRow()][piecePosition.getCol()].getPosition().setCol(piecePosition.getCol());

        this.puzzle[emptyPiecePosition.getRow()][emptyPiecePosition.getCol()] = temp;
        this.puzzle[emptyPiecePosition.getRow()][emptyPiecePosition.getCol()].getPosition().setRow(emptyPiecePosition.getRow());
        this.puzzle[emptyPiecePosition.getRow()][emptyPiecePosition.getCol()].getPosition().setCol(emptyPiecePosition.getCol());
    }

    public void move(Position piecePosition) {
        if (this.isMoveValid(piecePosition)) {
            this.swapPieces(piecePosition, new Position(this.emptyPiece.getPosition().getRow(), this.emptyPiece.getPosition().getCol()));
        }
    }

    public boolean isMoveValid(Position selectedPiecePosition) {
        return this.isEmptyPiece(selectedPiecePosition.getRow() - 1, selectedPiecePosition.getCol())
                || this.isEmptyPiece(selectedPiecePosition.getRow() + 1, selectedPiecePosition.getCol())
                || this.isEmptyPiece(selectedPiecePosition.getRow(), selectedPiecePosition.getCol() - 1)
                || this.isEmptyPiece(selectedPiecePosition.getRow(), selectedPiecePosition.getCol() + 1);
    }

    private boolean isEmptyPiece(int row, int col) {
        return row >= 0
                && row < GameBoard.ROW_COUNT
                && col >= 0
                && col < GameBoard.COL_COUNT
                && this.puzzle[row][col] == this.emptyPiece;
    }
}
