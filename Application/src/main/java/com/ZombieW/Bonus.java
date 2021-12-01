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
    private void getRewardImg() {
        try {
            reward = ImageIO.read(getClass().getResourceAsStream("/bonusReward.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void update(){
        if(this.x == gamePanel.mc.x && this.y == gamePanel.mc.y && !collected){
            gamePanel.mc.score += getPoints();
            setCollectionStatus(true);
        }
    }
    public void draw(Graphics2D g2){
//        BufferedImage image = reward;
        if(!getCollectStatus()) {
            g2.drawImage(reward, x, y, gamePanel.tileSize-5, gamePanel.tileSize-10, null);
        }
    }
}
