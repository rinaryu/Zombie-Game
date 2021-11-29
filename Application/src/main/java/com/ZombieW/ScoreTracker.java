package com.ZombieW;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DecimalFormat;

/**
 * This class has the static fields required for the player's score and timer
 */
public class ScoreTracker {
    GamePanel gamePanel;

    Font scoreFont;
    private double playTime;
    DecimalFormat tFormat = new DecimalFormat("#0.00");

    private BufferedImage boardImg;
    private BufferedImage timer;

    //positions of scoreboard and timer graphical images
    private final int posX = 300;
    private final int posY = 3;
    public Label foo;

    public ScoreTracker(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        playTime = 0;

        getImages();

        scoreFont = new Font("Arial", Font.BOLD, 18);
    }

    private void getImages() {
        try {
            boardImg = ImageIO.read(getClass().getResourceAsStream("/scoreboard.png"));
            timer = ImageIO.read(getClass().getResourceAsStream("/timeboard.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2) {
        int sizeW = gamePanel.tileSize + 40;
        int sizeH = gamePanel.tileSize;
        g2.drawImage(boardImg, posX, posY, sizeW, sizeH, null);
        g2.drawImage(timer, posX + sizeW + 20, posY, sizeW, sizeH, null);
    }

    public void drawScoreTime(Graphics2D g2) {
        int x = 347;
        int y = 32;
        String scoreNum = String.valueOf(gamePanel.mc.score);
        g2.setFont(scoreFont);
        g2.drawString(scoreNum, x, y);

        playTime += (double)1/60;
        g2.drawString(String.valueOf(tFormat.format(playTime)), x + 100, y);
    }

}
