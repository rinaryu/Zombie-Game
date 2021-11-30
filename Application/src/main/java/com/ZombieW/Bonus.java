package com.ZombieW;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Bonus extends Reward{
    private int pointsRewarded = 20;
    public Bonus(GamePanel gamePanel) {
        super(gamePanel);
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
}
