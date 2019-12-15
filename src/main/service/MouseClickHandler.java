package main.service;

import main.GameBoard;
import main.model.Position;
import main.ui.PuzzleGUI;

import java.awt.event.MouseEvent;

public class MouseClickHandler {
    private GameBoard gameBoard;

    public MouseClickHandler(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public void handle(MouseEvent e) {
        Position clickedPosition = new Position(e.getY() / PuzzleGUI.PIECE_SIZE, e.getX() / PuzzleGUI.PIECE_SIZE);
        this.gameBoard.handleMove(clickedPosition);
    }
}
