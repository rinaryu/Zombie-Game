package com.ZombieW;

import javax.swing.*;

public class Game{
    public static final int WIDTH = 160;
    public static final int HEIGHT = WIDTH / 12 * 9;
    public static final int SCALE = 3;
    public static final String NAME = "ZOMBIE";

    /**
     * Creates the window in which the game is running on and initializes the map/GamePanel
     * @param args
     */
    public static void main(String[] args){
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Zombie");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startGameThread();
    }
}

