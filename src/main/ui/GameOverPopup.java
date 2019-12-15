package main.ui;

import javax.swing.*;

public class GameOverPopup extends JFrame {
    private String message;

    public GameOverPopup(String message) {
        this.message = message;
    }

    public void show() {
        JOptionPane.showMessageDialog(this, this.message);
    }
}
