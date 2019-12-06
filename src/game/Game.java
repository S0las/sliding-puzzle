package game;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
    public Game() {
        super.setTitle("Sliding Puzzle");
        super.setPreferredSize(new Dimension(300, 330));
        super.getContentPane().add(new PuzzleGUI(), BorderLayout.CENTER);
        super.pack();
        super.setVisible(true);
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        try {
            new Game();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
