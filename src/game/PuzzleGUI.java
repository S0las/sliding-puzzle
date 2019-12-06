package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PuzzleGUI extends JPanel implements MouseListener {
    private static final int PIECE_SIZE = 100;

    private Font font = new Font("Serif", Font.PLAIN, 50);

    private PuzzleLogic puzzle = new PuzzleLogic();

    public PuzzleGUI() {
        this.setBackground(Color.black);
        this.addMouseListener(this);
    }

    public void paint(Graphics g) {
        super.paint(g);

        for (int row = 0; row < PuzzleLogic.ROW_COUNT; row++) {
            for (int col = 0; col < PuzzleLogic.COL_COUNT; col++) {
                int xPieceCoord = col * PIECE_SIZE;
                int yPieceCoord = row * PIECE_SIZE;
                String face = this.puzzle.getPiece(row, col).getFace();

                if (face != null) {
                    g.setColor(Color.white);
                    g.fillRect(xPieceCoord, yPieceCoord, PIECE_SIZE - 1, PIECE_SIZE - 1);

                    g.setColor(Color.black);
                    g.setFont(this.font);
                    g.drawString(face, xPieceCoord + 32, yPieceCoord + 70);
                }
            }
        }
    }

    public void mousePressed(MouseEvent e) {
        int col = e.getX() / PIECE_SIZE;
        int row = e.getY() / PIECE_SIZE;

        if (this.puzzle.isMoveValid(row, col)) {
            this.puzzle.move(row, col);
            this.repaint();

            if (this.puzzle.isGameOver()) {
                JFrame parent = new JFrame();

                JOptionPane.showMessageDialog(parent, "You win!");
                System.exit(0);
            }
        }
    }

    public void mouseClicked(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
