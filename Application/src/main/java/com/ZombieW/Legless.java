package com.ZombieW;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * class for different type of zombie. One without legs
 * which deals 3 damage
 */
class Legless extends Zombie{
    private int damage;
    private boolean defeated;
    public Legless(GamePanel gp, MainCharacter mc){
        super(gp, mc);
        damage = 3;
    }
    /**
     * Used for getting the image of the legless zombie
     *
     */
    public void getZombieImage() {
        try {

            sprite = ImageIO.read(getClass().getResourceAsStream("/leglessZombie.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * updating the score if the zombie and player land on same tile
     * or if the score is less than 0, the game is over.
     */
    public void update(){
        if(gamePanel.mc.x == this.getX() && gamePanel.mc.y == this.getY()){
            gamePanel.mc.score = gamePanel.mc.score - damage;
            defeated = true;
        }
    }
    /**
     * used for drawing the image to the game
     * @param g2 the graphics2D Object which is used to display the legless zombie onto the screen
     */
    public void draw(Graphics2D g2) {
        if(!defeated) {
            BufferedImage image = sprite;
            g2.drawImage(image, getX(), getY(), gamePanel.tileSize, gamePanel.tileSize, null);
        }
    }
}
