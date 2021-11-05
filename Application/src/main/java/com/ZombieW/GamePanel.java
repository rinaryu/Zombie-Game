package com.ZombieW;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    final int size = 16; //standard size
    final int scale = 3;

    final int tileSize = size * scale; //48*48 tiles
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;

    final int screenWidth = tileSize * maxScreenCol; //768 pixels
    final int screenHeight = tileSize * maxScreenRow; //576 pixels

    //fps
    int fps = 60;

    boolean running = false;



    KeyInput keyInput = new KeyInput();
    Thread mainThread;
    MainCharacter mc = new MainCharacter(this, keyInput);

    int locationX = 100;
    int locationY = 100;
    int oneMove = 4;

//    MainCharacter mainCharacter = new MainCharacter(this, keyInput);


    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);

        this.addKeyListener(keyInput);
        this.setFocusable(true);


    }

    public void startGameThread(){
        mainThread = new Thread(this);
        mainThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000/fps; //nanoseconds
        //we draw screen 60 times per second
        double nextDrawTime = System.nanoTime() + drawInterval;

        //running = true;
        while (mainThread != null){
            //long currentTime = System.currentTimeMillis();

            update();
            repaint();


            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;
                if (remainingTime < 0){
                    remainingTime = 0;
                }
                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void update(){

//        if(keyInput.up == true){
//            locationY -= oneMove;
//            System.out.println("here");
//        }else if(keyInput.down){
//            locationY += oneMove;
//            System.out.println("here");
//        }else if(keyInput.left){
//            locationX -= oneMove;
//            System.out.println("here");
//        }else if(keyInput.right) {
//            locationX += oneMove;
//            System.out.println("here");
//        }
        mc.update();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

//        g2.setColor(Color.white);
//        g2.fillRect(locationX, locationY, tileSize, tileSize);
        mc.draw(g2);
        g2.dispose();
    }
}