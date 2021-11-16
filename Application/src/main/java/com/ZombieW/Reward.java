package com.ZombieW;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Reward {
    private boolean collectionStatus;
    private int pointsRewarded;

    public BufferedImage reward;

    public Reward() {
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
}
