package com.ZombieW;

import java.awt.*;

public class MainCharacter extends Character{

    KeyInput keyInput;
    GamePanel gamePanel;

    public MainCharacter(GamePanel gp, KeyInput ki){
        this.gamePanel = gp;
        this.keyInput = ki;

        setDefaultValues();//for the parent class
    }

    public void setDefaultValues(){
        x = 100;
        y = 100;
        oneMove = 4;
    }

    public void update(){

        //System.out.println("heelo");

        if(keyInput.up == true){
            y -= oneMove;
            System.out.println("hello");
        }else if(keyInput.down){
            y += oneMove;
        }else if(keyInput.left){
            x -= oneMove;
        }else if(keyInput.right) {
            x += oneMove;
        }
        //System.out.println("update from mc");
    }

    public void draw(Graphics2D g2){

        //System.out.println("draw from mc");

        g2.setColor(Color.white);
        g2.fillRect(x, y, gamePanel.tileSize, gamePanel.tileSize);
    }
}
