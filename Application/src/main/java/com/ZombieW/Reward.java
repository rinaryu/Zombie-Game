package com.ZombieW;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Reward {
    private boolean collectionStatus;
    private int pointsRewarded;
    public int x;
    public int y;
    public BufferedImage reward;
    GamePanel gamePanel;
    public Reward(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        collectionStatus = false;
        pointsRewarded = 10;
        getRewardImg();
    }

    /**
     * Fetches the reward image and sets the reward attribute to the image fetched -- drawn using a different method
     */
    private void getRewardImg() {
        try {
            reward = ImageIO.read(getClass().getResourceAsStream("/reward.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Fetches the x location of the reward
     * @return returns the x location of the reward
     */
    public int getGridLocationX() {
        return ((x-52)/48+1);
    }

    /**
     * Fetches the y location of the reward
     * @return returns the y location of the reward
     */
    public int getGridLocationY(){
        return ((y-52)/48+1);
    }

    /**
     * Checks to see if reward has been collected
     * @return a boolean value, true if reward has been collected
     */
    public boolean getCollectStatus() { return collectionStatus; }

    /**
     * Fetch the number of points that should be rewarded
     * @return an integer that contains the amount of points rewarded
     */
    public int getPoints() { return pointsRewarded; }

    /**
     * Sets the attribute status to the boolean parameter
     * @param status
     */
    public void setCollectionStatus(boolean status) { collectionStatus = status; }
    public void update(){
        if(this.x == gamePanel.mc.x && this.y == gamePanel.mc.y){
            gamePanel.mc.score += getPoints();
            setCollectionStatus(true);
            gamePanel.mc.rewardsCollected++;
        }
    }
    public void draw(Graphics2D g2){
        BufferedImage image = reward;
        if(getCollectStatus() == false) {
            g2.drawImage(image, x, y, gamePanel.tileSize, gamePanel.tileSize, null);
        }
    }
}
