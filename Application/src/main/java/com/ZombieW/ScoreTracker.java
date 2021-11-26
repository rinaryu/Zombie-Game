package com.ZombieW;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.Buffer;

public class ScoreTracker {
    private int timeSinceStart;
    private BufferedImage boardImg;
    private BufferedImage timer;

    public ScoreTracker(){this.timeSinceStart=0;}

    public void setImages(Graphics2D g2) {
        try {
            boardImg = ImageIO.read(getClass().getResourceAsStream("/scoreboard.png"));
            timer = ImageIO.read(getClass().getResourceAsStream("/timeboard.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
