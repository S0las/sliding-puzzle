package main;

import main.service.MouseClickHandler;
import main.ui.GameWindow;

public class Game {
    private GameBoard gameBoard;
    private GameWindow gameWindow;
    private MouseClickHandler mouseClickHandler;

    private Game() {
        this.initLogic();
        this.initUI();
    }

    private void initLogic() {
        this.gameBoard = new GameBoard();
        this.mouseClickHandler = new MouseClickHandler(this.gameBoard);
    }

    private void initUI() {
        this.gameWindow = new GameWindow(this.gameBoard, this.mouseClickHandler);
    }

    public static void main(String[] args) {
        new Game();
    }
}
