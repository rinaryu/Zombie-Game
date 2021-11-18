package com.ZombieW;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

abstract class Zombie {
  public int damage;
  public int x;
  public int y;
  public int oneMove;
  GamePanel gamePanel;
  MainCharacter mc;
  public BufferedImage sprite;

  /**
   * Returns a Zombie object which can be then painted onto the GamePanel Object
   * @param gp the GamePanel object in which the zombie is projected onto
   * @param mc the MainCharacter object that the zombie must move towards
   */
  public Zombie(GamePanel gp, MainCharacter mc){
    this.gamePanel = gp;
    this.mc = mc;
    setDefaultValues();//for the parent class
    getZombieImage();

  }
  /**
   * Sets the default values for the object when initialized
   */
  public void setDefaultValues() {
    x = 340;
    y = 340;
    oneMove = 16*3; // was 4
  }

  /**
   * Returns an integer that has the amount of damage that a zombie can do when
   * close enough to a player
   * @return the amount of damage in an integer
   */
  public int getDamage(){
      return damage;
  }

  /**
   * Sets the damage integer attribute to the provided parameter
   * @param damage the amount of damage you want the zombie to have
   */
  public void setDamage(int damage){
      this.damage = damage;
  }

  abstract void getZombieImage();

  /**
   * Displays the zombie onto the GamePanel object
   * @param g2 the graphics2D Object which is used to display the zombie onto the screen
   */
  public void draw(Graphics2D g2) {

    BufferedImage image = sprite;
    g2.drawImage(image, x, y, gamePanel.tileSize, gamePanel.tileSize, null);

  }
}