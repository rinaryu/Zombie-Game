package com.ZombieW;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Class that holds static fields for the in-game rewards.
 * Also has getter/setter methods for the certain static fields.
 */
public class Reward {
    private boolean collected;
    private int pointsRewarded;
    public int x;
    public int y;
    public BufferedImage reward;
    GamePanel gamePanel;

    public Reward(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        collected = false;
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
     * Checks to see if reward has been collected
     * @return a boolean value, true if reward has been collected
     */
    public boolean getCollectStatus() { return collected; }
    /**
     * Fetch the number of points that should be rewarded
     * @return an integer that contains the amount of points rewarded
     */
    public int getPoints() { return pointsRewarded; }

    /**
     * Sets the attribute status to the boolean parameter
     * @param status
     */
    private void setCollectionStatus(boolean status) { collected = status; }
    public void update(){
        if(this.x == gamePanel.mc.x && this.y == gamePanel.mc.y && !collected){
            gamePanel.mc.score += getPoints();
            setCollectionStatus(true);
            gamePanel.mc.rewardsCollected++;
        }
    }

    /**
     * Draws reward image if it has not been collected yet.
     * @param g2
     */
    public void draw(Graphics2D g2){
//        BufferedImage image = reward;
        if(!getCollectStatus()) {
            g2.drawImage(reward, x, y, gamePanel.tileSize-5, gamePanel.tileSize-10, null);
        }
    }
}
