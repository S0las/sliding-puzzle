package main.ui;

import main.GameBoard;
import main.service.MouseClickHandler;
import main.model.Position;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PuzzleGUI extends JPanel implements MouseListener {
    public static final int PIECE_SIZE = 100;
    private Font font = new Font("Serif", Font.PLAIN, 50);
    private GameBoard gameBoard;
    private MouseClickHandler mouseClickHandler;

    public PuzzleGUI(GameBoard gameBoard, MouseClickHandler mouseClickHandler) {
        this.gameBoard = gameBoard;
        this.mouseClickHandler = mouseClickHandler;

        this.setBackground(Color.black);
        this.addMouseListener(this);
    }

    public void paint(Graphics g) {
        super.paint(g);

        for (int row = 0; row < GameBoard.ROW_COUNT; row++) {
            for (int col = 0; col < GameBoard.COL_COUNT; col++) {
                this.paintPuzzlePiece(g, row, col);
            }
        }
    }

    private void paintPuzzlePiece(Graphics g, int row, int col) {
        int xPieceCoord = col * PIECE_SIZE;
        int yPieceCoord = row * PIECE_SIZE;
        String face = this.gameBoard.getPiece(new Position(row, col)).getFace();

        if (face != null) {
            g.setColor(Color.white);
            g.fillRect(xPieceCoord, yPieceCoord, PIECE_SIZE - 1, PIECE_SIZE - 1);

            g.setColor(Color.black);
            g.setFont(this.font);
            g.drawString(face, xPieceCoord + 32, yPieceCoord + 70);
        }
    }

    public void mousePressed(MouseEvent e) {
        this.mouseClickHandler.handle(e);
        this.repaint();
    }

    public void mouseClicked(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
