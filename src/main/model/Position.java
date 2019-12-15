package main.model;

public class Position {
    private int row;
    private int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public Position setRow(int row) {
        this.row = row;
        return this;
    }

    public Position setCol(int col) {
        this.col = col;
        return this;
    }
}
