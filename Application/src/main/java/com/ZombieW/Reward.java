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
        this.x = 292;
        this.y = 292;
        collectionStatus = false;
        getRewardImg();
    }
    //gets and sets the reward image -- drawn using a different method
    private void getRewardImg() {
        try {
            reward = ImageIO.read(getClass().getResourceAsStream("/reward.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //TODO: randomly generate location for reward
    public int getLocation() {
        return 0;
    }

    public boolean getCollectStatus() { return collectionStatus; }

    public int getPoints() { return pointsRewarded; }

    public void setCollectionStatus(boolean status) { collectionStatus = status; }
    public void update(){
        if(this.x == gamePanel.mc.x && this.y == gamePanel.mc.y){
            gamePanel.mc.score += pointsRewarded;
            collectionStatus = true;
        }
    }
    public void draw(Graphics2D g2){
        BufferedImage image = reward;
        if(collectionStatus == false) {
            g2.drawImage(image, x, y, gamePanel.tileSize, gamePanel.tileSize, null);
        }
    }
}
