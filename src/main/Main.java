package main;

import main.GamePanel;

import javax.swing.JFrame;
public class Main {
    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Dragon's Lair");
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack(); // Loads the preferred Dimensions
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        gamePanel.startGameThread();
    }
}