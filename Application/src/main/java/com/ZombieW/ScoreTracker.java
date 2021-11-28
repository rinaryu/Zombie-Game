package com.ZombieW;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * This class has the static fields required for the player's score and timer
 */
public class ScoreTracker {
    private int timeStart;
    private BufferedImage boardImg;
    private BufferedImage timer;
    private final int posX = 300;
    private final int posY = 3;

    GamePanel gamePanel;

    public ScoreTracker(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        this.timeStart = 0;

        getImages();
    }

    private void getImages() {
        try {
            boardImg = ImageIO.read(getClass().getResourceAsStream("/scoreboard.png"));
            timer = ImageIO.read(getClass().getResourceAsStream("/timeboard.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    public BufferedImage getBoardImg() { return boardImg;}

    public void draw(Graphics2D g2) {
        int sizeW = gamePanel.tileSize + 40;
        int sizeH = gamePanel.tileSize;
        g2.drawImage(boardImg, posX, posY, sizeW, sizeH, null);
        g2.drawImage(timer, posX + sizeW + 20, posY, sizeW, sizeH, null);
    }

}
