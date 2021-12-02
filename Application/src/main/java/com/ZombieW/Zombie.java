package com.ZombieW;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * This is an abstract class for a zombie character.
 * It contains static attributes and getter/setter methods.
 * As well as a draw method for the zombie graphic.
 */
abstract class Zombie {
  private int x;
  private int y;
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

  abstract void getZombieImage();

  /**
   * Displays the zombie onto the GamePanel object
   * @param g2 the graphics2D Object which is used to display the zombie onto the screen
   */
  abstract public void draw(Graphics2D g2);
  public int getX(){
    return x;
  }
  public int getY(){
    return y;
  }
  public void addX(int oneMove){
    x += oneMove;
  }
  public void addY(int oneMove){
    y += oneMove;
  }
  public void subX(int oneMove){
    x -= oneMove;
  }
  public void subY(int oneMove){
    y -= oneMove;
  }
  public void setX(int x){
    this.x = x;
  }
  public void setY(int y){
    this.y = y;
  }
}