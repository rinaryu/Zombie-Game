package com.ZombieW;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Exit {
    public GamePanel gamePanel;
    public boolean exitable;
    public BufferedImage sprite;
    private int x;
    private int y;

    public Exit(GamePanel gp) {
        this.gamePanel = gp;
        this.exitable = false;
        this.x = 676;
        this.y = 484;
        getExitImage();
    }
    public void getExitImage() {
        try {

            sprite = ImageIO.read(getClass().getResourceAsStream("/exit.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void update(){
        if(gamePanel.mc.rewardsCollected == 5){
            exitable = true;
        }
        if(exitable){
            System.out.println("GG");
            //win here
        }
    }
    public void draw(Graphics2D g2) {
        BufferedImage image = sprite;
        g2.drawImage(image, x, y, gamePanel.tileSize, gamePanel.tileSize, null);

    }

}
