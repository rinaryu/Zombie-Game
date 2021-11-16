package com.ZombieW;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.nio.Buffer;

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
        score = 0;
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

        if (keyInput.up) {
            if(gamePanel.gridManager.mapGridNum[((x-52)/48+1)][((y-oneMove-52)/48+1)] != 1) {
                y -= oneMove;
            }
            System.out.println("X: " + x + ", Y: " + y);
//            System.out.println(gamePanel.gridManager.mapGridNum[((x-52)/48+1)][((y-52)/48+1)]);
        } else if (keyInput.down) {
            if(gamePanel.gridManager.mapGridNum[((x-52)/48+1)][((y+oneMove-52)/48+1)] != 1){
                y += oneMove;
            }
            System.out.println("X: " + ((x-52)/48+1) + ", Y: " + ((y-52)/48+1));
        } else if (keyInput.left) {
            if(gamePanel.gridManager.mapGridNum[((x-oneMove-52)/48+1)][((y-52)/48+1)] != 1){
                x -= oneMove;
            }
            System.out.println("X: " + ((x-52)/48+1) + ", Y: " + ((y-52)/48+1));
        } else if (keyInput.right) {
            if(gamePanel.gridManager.mapGridNum[((x+oneMove-52)/48+1)][((y-52)/48+1)] != 1) {
                x += oneMove;
            }
            System.out.println("X: " + ((x-52)/48+1) + ", Y: " + ((y-52)/48+1));
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
