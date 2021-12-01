package com.ZombieW;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 *Class used to making the zombie that chases the player
 */
class Chaser extends Zombie{
    private BufferedImage gameOverSc;

    /**
     * @param gp is the panel on which the object will be displayed on
     * @param mc is the main character that the zombie is tring to get
     */
    public Chaser(GamePanel gp, MainCharacter mc){
        super(gp, mc);
    }

    /**
     * getting the image of the chaser zombie
     */
    public void getZombieImage() {
        try {
            sprite = ImageIO.read(getClass().getResourceAsStream("/movingZombie.png"));
            gameOverSc = ImageIO.read(getClass().getResourceAsStream("/gameOver.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * this allows for the zombie to chase the character
     * if the character is caught the game is over
     */
    public void update() {
        if (mc.x < this.x && gamePanel.gridManager.mapGridNum[((x - oneMove - 52) / 48 + 1)][((y - 52) / 48 + 1)] != 1) {
            x -= oneMove;
        } else if (mc.x > this.x && gamePanel.gridManager.mapGridNum[((x + oneMove - 52) / 48 + 1)][((y - 52) / 48 + 1)] != 1) {
            x += oneMove;
        } else {
            if (mc.y < this.y && gamePanel.gridManager.mapGridNum[((x - 52) / 48 + 1)][((y - oneMove - 52) / 48 + 1)] != 1) {
                y -= oneMove;
            } else if (mc.y > this.y && gamePanel.gridManager.mapGridNum[((x - 52) / 48 + 1)][((y + oneMove - 52) / 48 + 1)] != 1) {
                y += oneMove;
            }
        }
    }
    /**
     * used to draw the moving zombie to the game
     * @param g2 the graphics2D Object which is used to display the chaser zombie onto the screen
     */
    public void draw(Graphics2D g2) {
        BufferedImage image = sprite;
        g2.drawImage(image, x, y, gamePanel.tileSize, gamePanel.tileSize, null);

        if(this.x == gamePanel.mc.x && this.y == gamePanel.mc.y){
            gamePanel.exit.drawResult(g2, false);
        }
    }

}
