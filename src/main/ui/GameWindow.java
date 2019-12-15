package main.ui;

import main.GameBoard;
import main.service.MouseClickHandler;
import main.MoveCounter;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    private PuzzleGUI puzzleGUI;
    private static JLabel moveCountLabel = new JLabel("Moves: " + MoveCounter.getValue());
    private static final int WINDOW_WIDTH = 310;
    private static final int WINDOW_HEIGHT = 355;

    private GameBoard gameBoard;

    public GameWindow(GameBoard gameBoard, MouseClickHandler mouseClickHandler) {
        this.gameBoard = gameBoard;
        this.puzzleGUI = new PuzzleGUI(gameBoard, mouseClickHandler);

        this.init();
    }

    private void init() {
        super.setTitle("Sliding Puzzle");
        super.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        super.getContentPane().add(puzzleGUI, BorderLayout.CENTER);
        super.getContentPane().add(moveCountLabel, BorderLayout.SOUTH);
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        super.pack();
        super.setVisible(true);
    }

    public static void updateMoveCount() {
        moveCountLabel.setText("Moves: " + MoveCounter.getValue());
    }
}
