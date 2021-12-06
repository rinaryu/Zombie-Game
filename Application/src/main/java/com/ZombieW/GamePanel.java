package com.ZombieW;

import javax.swing.*;
import java.awt.*;
import java.lang.Math;
/**
 * This class creates the main game panel that draws all the graphical assets including the grid map board and its
 * frame size.
 */
public class GamePanel extends JPanel implements Runnable {
    public boolean gameCont = true;
    public boolean updateZombFlag = false;
    final int size = 16; //standard size
    final int scale = 3;

    final int tileSize = size * scale; //48*48 tiles
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;

    final int screenWidth = tileSize * maxScreenCol; //768 pixels
    final int screenHeight = tileSize * maxScreenRow; //576 pixels

    //fps
    int fps = 10;

    public GridManager gridManager = new GridManager(this);
    public KeyInput keyInput = new KeyInput();
    Thread mainThread;

    ScoreTracker scores = new ScoreTracker(this);

    public MainCharacter mc = new MainCharacter(this, keyInput);
    public Chaser movingZomb = new Chaser(this, mc);
    public Legless zomb[] = new Legless[3];
    public Reward r[] = new Reward[5];
    public Exit exit = new Exit(this);
    public Bonus bonusReward = new Bonus(this);

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
            zomb[i].setX((temp-1)*48+52);
            zomb[i].setY((temp2-1)*48+52);
        }
        int temp = generateRandomX();
        int temp2 = generateRandomY();
        while(this.gridManager.mapGridNum[temp][temp2] == 1){
            temp = generateRandomX();
            temp2 = generateRandomY();
        }
        bonusReward.x = (temp-1)*48+52;
        bonusReward.y = (temp2-1)*48+52;
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
            if(updateZombFlag){
                updateZomb();
            }
            update();
            repaint();

            if ((keyInput.left || keyInput.right || keyInput.up || keyInput.down) && counter == 0){
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
        for(int i = 0; i < r.length; i++){
            r[i].update();
        }
        for(int i = 0; i < zomb.length; i++){
            zomb[i].update();
        }
        bonusReward.update();
        exit.update();
    }
    public void updateZomb(){
        movingZomb.update();
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
        bonusReward.draw(g2);
        movingZomb.draw(g2);
        if(exit.isExitable()) {
            exit.draw(g2);
            if(mc.x == 676 && mc.y == 484) { // player makes it to the door
                exit.drawResult(g2, true);
            }
        }
        if (mc.score < 0) { // player score is negative
            exit.drawResult(g2, false);
        }
        scores.drawScoreTime(g2);
        g2.dispose();
    }
}
