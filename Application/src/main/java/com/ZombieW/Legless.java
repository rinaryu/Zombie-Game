package com.ZombieW;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

class Legless extends Zombie{
    private int damage;
    public boolean defeated;
    public Legless(GamePanel gp, MainCharacter mc){
        super(gp, mc);
        damage = 3;
    }
    public void getZombieImage() {
        try {

            sprite = ImageIO.read(getClass().getResourceAsStream("/leglessZombie.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void update(){
        if(gamePanel.mc.x == this.x && gamePanel.mc.y == this.y){
            gamePanel.mc.score = gamePanel.mc.score - damage;
            defeated = true;
        }
        if(mc.score < 0){
            System.out.println("Game Over");
        }
    }
    public void draw(Graphics2D g2) {
        if(!defeated) {
            BufferedImage image = sprite;
            g2.drawImage(image, x, y, gamePanel.tileSize, gamePanel.tileSize, null);
        }
    }
}