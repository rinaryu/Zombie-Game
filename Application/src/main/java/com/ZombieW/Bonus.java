package com.ZombieW;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Bonus extends Reward{

    public Bonus(GamePanel gamePanel) {
        super(gamePanel);
        pointsRewarded = 20;
        getRewardImg();
    }

    /**
     * fetches and sets the reward attribute to the proper sprite
     */
    private void getRewardImg() {
        try {
            reward = ImageIO.read(getClass().getResourceAsStream("/bonusReward.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * checks to see if player is at the position of the bonus reward, then adds the points to the player, sets collection status to true so the game knows the item has been collected
     */
    public void update(){
        if(this.x == gamePanel.mc.x && this.y == gamePanel.mc.y && !collected){
            gamePanel.mc.score += getPoints();
            setCollectionStatus(true);
        }
    }

    /**
     * draw the image on the g2 surface
     * @param g2 surface on which the imagine is drawn on
     */
    public void draw(Graphics2D g2){
        if(!getCollectStatus()) {
            g2.drawImage(reward, x, y, gamePanel.tileSize-5, gamePanel.tileSize-10, null);
        }
    }
}
