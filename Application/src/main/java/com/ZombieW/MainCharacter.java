package com.ZombieW;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Sets all attributes required for main character as well as its graphic image.
 */
public class MainCharacter{
    public int x, y;
    public int oneMove;
    public int score;
    public BufferedImage sprite;
    public KeyInput keyInput;
    GamePanel gamePanel;
    private int rewardsCollected;

    /**
     * Returns a MainCharacter object which can then be drawn onto the screen
     * @param gp the panel on which the object will be displayed on
     * @param ki the object which handles the key inputs from the user used to
     *           control the character.
     */
    public MainCharacter(GamePanel gp, KeyInput ki) {
        this.gamePanel = gp;
        this.keyInput = ki;

        setDefaultValues();//for the parent class
        getMainCharacterImage();
    }

    /**
     * Sets the default values for the object when initialized
     */
    public void setDefaultValues() {
        x = 100;
        y = 100;
        score = 0;
        oneMove = 16*3; // was 4
        rewardsCollected = 0;
    }

    /**
     * Fetches the image/sprite from the folder and sets the sprite attribute in the
     * Main character class to the fetched image
     */
    public void getMainCharacterImage() {
        try {
            sprite = ImageIO.read(getClass().getResourceAsStream("/player.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public BufferedImage getSprite(){
        return sprite;
    }

    /**
     * Checks the KeyInput object in the MainCharacter class for user input and moves the
     * character accordingly on the GamePanel Object.
     */
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void moveUp(){
        y-=oneMove;
    }
    public void moveDown(){
        y+=oneMove;
    }
    public void moveLeft(){
        x -= oneMove;
    }
    public void moveRight(){
        x += oneMove;
    }

    public void update() {
        if (keyInput.up) {
            if(gamePanel.gridManager.mapGridNum[((x-52)/48+1)][((y-oneMove-52)/48+1)] != 1) {
                y -= oneMove;
            }
        } else if (keyInput.down) {
            if(gamePanel.gridManager.mapGridNum[((x-52)/48+1)][((y+oneMove-52)/48+1)] != 1){
                y += oneMove;
            }
        } else if (keyInput.left) {
            if(gamePanel.gridManager.mapGridNum[((x-oneMove-52)/48+1)][((y-52)/48+1)] != 1){
                x -= oneMove;
            }
        } else if (keyInput.right) {
            if(gamePanel.gridManager.mapGridNum[((x+oneMove-52)/48+1)][((y-52)/48+1)] != 1) {
                x += oneMove;
            }
        }
        else if(keyInput.check){
            System.out.println((gamePanel.movingZomb.getX()-(float)52) /(float)48+(float)1);
            System.out.println((gamePanel.movingZomb.getY()-52)/48+1);

        }
    }

    /**
     * Displays the character onto the GamePanel object
     * @param g2 the graphics2D Object which is used to display the main character onto the screen
     */
    public void draw(Graphics2D g2) {
        BufferedImage image = sprite;
        g2.drawImage(image, x, y, gamePanel.tileSize-18, gamePanel.tileSize, null);
    }

    public int getRewardsCollected() {
        return rewardsCollected;
    }
    public void addReward(){
        rewardsCollected += 1;
    }
}
