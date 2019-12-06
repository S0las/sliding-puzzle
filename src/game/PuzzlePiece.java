package game;

public class PuzzlePiece {
    private int row;
    private int col;
    private int finalRow;
    private int finalCol;
    private String face;

    public PuzzlePiece(int row, int col, String face) {
        this.row = row;
        this.col = col;
        this.finalRow = row;
        this.finalCol = col;
        this.face = face;
    }

    public String getFace() {
        return face;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean isInFinalPosition() {
        return this.row == this.finalRow
                && this.col == this.finalCol;
    }
}
