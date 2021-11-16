package com.ZombieW;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Zombie {
  private int damage;
  public int x;
  public int y;
  public int oneMove;
  GamePanel gamePanel;
  MainCharacter mc;
  public BufferedImage sprite;

  public Zombie(GamePanel gp, MainCharacter mc){
    this.gamePanel = gp;
    this.mc = mc;
    this.damage = 3;

    setDefaultValues();//for the parent class
    getZombieImage();

  }
  public void setDefaultValues() {
    x = 340;
    y = 340;
    oneMove = 16*3; // was 4
  }
  public int getDamage(){
      return damage;
  }
  public void setDamage(int damage){
      this.damage = damage;
  }
  public void getZombieImage() {
    try {

      sprite = ImageIO.read(getClass().getResourceAsStream("/leglessZombie.png"));


    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  public void update() {
    if(mc.zombMove){
      x -= oneMove;
      mc.zombMove = false;
    }

  }
  public void draw(Graphics2D g2) {

    BufferedImage image = sprite;
    g2.drawImage(image, x, y, gamePanel.tileSize+6, gamePanel.tileSize, null);

  }
}