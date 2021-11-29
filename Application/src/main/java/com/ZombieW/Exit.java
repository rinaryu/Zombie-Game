package com.ZombieW;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Class used for the exit of the game
 */
public class Exit {
    public GamePanel gamePanel;
    public boolean exitable;

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
        if(gamePanel.mc.rewardsCollected == 5){
            exitable = true;
        }
    }

    /**
     * @param g2 the graphics2D Object which is used to display the exit onto the screen
     */
    public void draw(Graphics2D g2) {
        g2.drawImage(exitDoor, x, y, gamePanel.tileSize, gamePanel.tileSize, null);
    }

    public void drawWin(Graphics2D g2) {
        int x = 150;
        int y = 50;
        g2.drawImage(winScreen, x, y, gamePanel.tileSize*10, gamePanel.tileSize*8, null);
        gamePanel.gameCont = false;
    }

    public void drawLose(Graphics2D g2) {
        int posX = 150;
        int posY = 50;
        g2.drawImage(gameOverSc, posX, posY, gamePanel.tileSize*10, gamePanel.tileSize*8, null);
        gamePanel.gameCont = false;
    }

}
