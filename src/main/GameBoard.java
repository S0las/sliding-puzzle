package main;

import main.model.Position;
import main.model.puzzle.PuzzlePiece;
import main.model.puzzle.Puzzle;
import main.model.puzzle.PuzzleFactory;
import main.model.puzzle.PuzzleType;
import main.service.PuzzleMover;
import main.ui.GameOverPopup;
import main.ui.GameWindow;

public class GameBoard {
    public static final int ROW_COUNT = 3;
    public static final int COL_COUNT = 3;

    private Puzzle puzzle;
    private PuzzleMover puzzleMover;


    public GameBoard() {
        this.puzzle = PuzzleFactory.getInstance(PuzzleType.SHUFFLED);
        this.puzzleMover = new PuzzleMover(this.puzzle);
    }

    public GameBoard(Puzzle puzzle) {
        this.puzzle = puzzle;
        this.puzzleMover = new PuzzleMover(this.puzzle);
    }

    public PuzzlePiece getPiece(Position position) {
        return this.puzzle.getPuzzle()[position.getRow()][position.getCol()];
    }

    public void handleMove(Position position) {
        if (this.puzzleMover.isMoveValid(position)) {
            this.puzzleMover.move(position);

            MoveCounter.increment();
            GameWindow.updateMoveCount();

            this.isGameFinished();
        }
    }

    private void isGameFinished() {
        if (this.puzzle.isPuzzleComplete()) {
            GameOverPopup gameOverPopup = new GameOverPopup("You win! It took you " + MoveCounter.getValue() + " moves!");
            gameOverPopup.show();

            System.exit(0);
        }
    }

}
