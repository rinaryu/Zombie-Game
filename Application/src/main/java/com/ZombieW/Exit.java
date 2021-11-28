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
    private BufferedImage sprite;
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
            sprite = ImageIO.read(getClass().getResourceAsStream("/exit.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    } 

    /**
     * this class is for whether the exit is open or not
     * 
     */
    public void update(){
        if(gamePanel.mc.rewardsCollected == 6){
            exitable = true;
            System.out.println("exitable becomes true");
        }
        if(exitable && gamePanel.mc.x == 676 && gamePanel.mc.y == 484){
            System.out.println("aldjfalsd");
            //win here
        }
    }

    /**
     * @param g2 the graphics2D Object which is used to display the exit onto the screen
     */
    public void draw(Graphics2D g2) {
        BufferedImage image = sprite;
        g2.drawImage(image, x, y, gamePanel.tileSize, gamePanel.tileSize, null);

    }

}
