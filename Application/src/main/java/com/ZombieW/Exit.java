package com.ZombieW;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Class used for the exit of the game
 */
public class Exit {
    private GamePanel gamePanel;
    private boolean exitable;

    private BufferedImage exitDoor;
    private BufferedImage winScreen;
    private BufferedImage gameOverSc;

    private int x;
    private int y;

    /**
     * @param gp the panel on which the object will be displayed on
     */
    public Exit(GamePanel gp) {
        this.gamePanel = gp;
        this.exitable = false;
        this.x = 676;
        this.y = 484;
        getExitImage();
    }
    public boolean isExitable(){
        return exitable;
    }
    /**
     * getting and using image of the door/exit
     */
    public void getExitImage() {
        try {
            exitDoor = ImageIO.read(getClass().getResourceAsStream("/exit.png"));
            winScreen = ImageIO.read(getClass().getResourceAsStream("/win.png"));
            gameOverSc = ImageIO.read(getClass().getResourceAsStream("/gameOver.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    } 

    /**
     * this class is for whether the exit is open or not
     * 
     */
    public void update(){
        if(gamePanel.mc.getRewardsCollected() == 5){
            exitable = true;
        }
    }

    /**
     * @param g2 the graphics2D Object which is used to display the exit onto the screen
     */
    public void draw(Graphics2D g2) {
        g2.drawImage(exitDoor, x, y, gamePanel.tileSize, gamePanel.tileSize, null);
    }

    /**
     * draws the winning screen or gameover screen
     * @param g2
     * @param res
     */
    public void drawResult(Graphics2D g2, boolean res) {
        int x = 150;
        int y = 50;
        if(res) {
            g2.drawImage(winScreen, x, y, gamePanel.tileSize*10, gamePanel.tileSize*8, null);
        } else {
            g2.drawImage(gameOverSc, x, y, gamePanel.tileSize*10, gamePanel.tileSize*8, null);
        }
        gamePanel.gameCont = false;
    }

}
