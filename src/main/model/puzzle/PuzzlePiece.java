package main.model.puzzle;

import main.model.Position;

public class PuzzlePiece {
    protected Position position;
    protected Position finalPosition;
    protected String face;

    public PuzzlePiece(Position position, String face) {
        this.position = position;
        this.finalPosition = new Position(position.getRow(), position.getCol());
        this.face = face;
    }

    public PuzzlePiece(Position position) {
        this.position = position;
        this.finalPosition = new Position(position.getRow(), position.getCol());
    }

    public String getFace() {
        return face;
    }

    public void setPosition(Position where) {
        this.position = where;
    }

    public Position getPosition() {
        return this.position;
    }

    public boolean isInFinalPosition() {
        return this.position.getRow() == this.finalPosition.getRow()
                && this.position.getCol() == this.finalPosition.getCol();
    }
}
