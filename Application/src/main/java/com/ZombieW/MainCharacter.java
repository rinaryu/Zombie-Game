package com.ZombieW;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class MainCharacter extends Character {

    KeyInput keyInput;
    GamePanel gamePanel;


    public MainCharacter(GamePanel gp, KeyInput ki) {
        this.gamePanel = gp;
        this.keyInput = ki;

        setDefaultValues();//for the parent class
        getMainCharacterImage();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        oneMove = 16*3; // was 4
    }

    public void getMainCharacterImage() {
        try {

            sprite = ImageIO.read(getClass().getResourceAsStream("/art.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {

        //System.out.println("heelo");

        if (keyInput.up == true) {
            y -= oneMove;
            System.out.println("hello");
        } else if (keyInput.down) {
            y += oneMove;
        } else if (keyInput.left) {
            x -= oneMove;
        } else if (keyInput.right) {
            x += oneMove;
        }
        //System.out.println("update from mc");
    }

    public void draw(Graphics2D g2) {

        //System.out.println("draw from mc");

//        g2.setColor(Color.white);
//        g2.fillRect(x, y, gamePanel.tileSize, gamePanel.tileSize);

        BufferedImage image = sprite;
        g2.drawImage(image, x, y, gamePanel.tileSize, gamePanel.tileSize, null);

    }
}
