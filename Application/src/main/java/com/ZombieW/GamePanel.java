package com.ZombieW;

import javax.swing.*;
import java.awt.*;

/**
 * This class creates the main game panel that draws all the graphical assets including the grid map board and its
 * frame size.
 */
public class GamePanel extends JPanel implements Runnable {
    public boolean gameCont = true;

    final int size = 16; //standard size
    final int scale = 3;

    final int tileSize = size * scale; //48*48 tiles
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;

    final int screenWidth = tileSize * maxScreenCol; //768 pixels
    final int screenHeight = tileSize * maxScreenRow; //576 pixels

    //fps
    int fps = 10;

    GridManager gridManager = new GridManager(this);
    KeyInput keyInput = new KeyInput();
    Thread mainThread;

    ScoreTracker scores = new ScoreTracker(this);

    MainCharacter mc = new MainCharacter(this, keyInput);
    Chaser movingZomb = new Chaser(this, mc);
    Legless zomb[] = new Legless[3];
    Reward r[] = new Reward[5];
    Exit exit = new Exit(this);

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);

        this.addKeyListener(keyInput);
        this.setFocusable(true);

        this.setLayout(null);

        for(int i = 0; i < r.length; i++){
            r[i] = new Reward(this);
            int temp = generateRandomX();
            int temp2 = generateRandomY();
            while(this.gridManager.mapGridNum[temp][temp2] == 1){
                temp = generateRandomX();
                temp2 = generateRandomY();
            }
            r[i].x = (temp-1)*48+52;
            r[i].y = (temp2-1)*48+52;
        }
        for(int i = 0; i < zomb.length; i++){
            zomb[i] = new Legless(this, mc);
            int temp = generateRandomX();
            int temp2 = generateRandomY();
            while(this.gridManager.mapGridNum[temp][temp2] == 1){
                temp = generateRandomX();
                temp2 = generateRandomY();
            }
            zomb[i].x = (temp-1)*48+52;
            zomb[i].y = (temp2-1)*48+52;
        }

    }

    /**
     * Generates random x coordinate integer value.
     * @return x coordinate
     */
    public int generateRandomX(){
        return (int) ((Math.random() * (maxScreenCol - 2 - 1)) + 1);
    }

    /**
     * Generates random y coordinate integer value.
     * @return y coordinate
     */
    public int generateRandomY(){
        return (int) ((Math.random() * (maxScreenRow - 2 - 1)) + 1);
    }

    /**
     * Starts the main game thread.
     */
    public void startGameThread(){
        mainThread = new Thread(this);
        mainThread.start();
    }

    /**
     * This method includes the game loop thread and updates the character's
     * position after every movement.
     */
    @Override
    public void run() {
        double drawInterval = 1000000000/fps; //nanoseconds
        //we draw screen 60 times per second
        double nextDrawTime = System.nanoTime() + drawInterval;

        int counter = 0;
        while (mainThread != null && gameCont){
//            update();
//            repaint();

            if ((keyInput.left || keyInput.right || keyInput.up || keyInput.down) && counter == 0){
                update();
                repaint();

                counter = 1;
                keyInput.left = false;
                keyInput.right = false;
                keyInput.up = false;
                keyInput.down = false;
            }

            try {
                double remainingTime = (nextDrawTime - System.nanoTime())/1000000;
                counter = 0;
                if (remainingTime < 0) {
                    remainingTime = 0;
                }
                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Updates main character and enemy character position.
     */
    public void update(){
        mc.update();
        movingZomb.update();
        for(int i = 0; i < r.length; i++){
            r[i].update();
        }
        for(int i = 0; i < zomb.length; i++){
            zomb[i].update();
        }
        exit.update();
    }

    /**
     * Calls draw methods to create graphics on game frame for each respective asset.
     * @param g
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        gridManager.draw(g2);
        mc.draw(g2);

        scores.draw(g2); //score board graphic image

        for(int i = 0; i < zomb.length; i++){
            zomb[i].draw(g2);
        }
        for(int i = 0; i < r.length; i++){
            r[i].draw(g2);
        }
        movingZomb.draw(g2);
        if(exit.exitable) {
            exit.draw(g2);
            if(mc.x == 676 && mc.y == 484) { // player makes it to the door
                exit.drawWin(g2);
            }
        }
        if (mc.score < 0) { // player score is negative
            exit.drawLose(g2);
        }
        scores.drawScoreTime(g2);
        g2.dispose();
    }
}
