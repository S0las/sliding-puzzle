package main.model.puzzle;

import main.model.Position;

public class EmptyPiece extends PuzzlePiece {
    public EmptyPiece(Position position) {
        super(position);
        this.face = null;
    }
}
