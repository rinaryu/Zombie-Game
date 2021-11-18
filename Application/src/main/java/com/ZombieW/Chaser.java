package com.ZombieW;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

class Chaser extends Zombie{
    public Chaser(GamePanel gp, MainCharacter mc){
        super(gp, mc);
    }
    public void getZombieImage() {
        try {

            sprite = ImageIO.read(getClass().getResourceAsStream("/movingZombie.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
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
        if(this.x == gamePanel.mc.x && this.y == gamePanel.mc.y){
            System.out.println("Game Over");
        }
    }
    public void draw(Graphics2D g2) {

        BufferedImage image = sprite;
        g2.drawImage(image, x, y, gamePanel.tileSize, gamePanel.tileSize, null);

    }

}