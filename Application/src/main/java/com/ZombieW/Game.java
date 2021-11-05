package com.ZombieW;

import javax.swing.*;

public class Game{

    private static final long serialVersionUID = 1L;

    public static final int WIDTH = 160;
    public static final int HEIGHT = WIDTH / 12 * 9;
    public static final int SCALE = 3;
    public static final String NAME = "ZOMBIE";
    public int tickCount = 0;
    public boolean running = false;


    public static void main(String[] args){
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        window.setTitle("Zombie");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startGameThread();

    }

<<<<<<< HEAD
=======
//    public void start(){ //syncronized
//        running = true;
//        new Thread(this).start();
//    }

//    public synchronized void stop(){
//        running = false;
//    }
//
//    @Override
//    public void run() {

        //init();

//        Runnable update = new Runnable() {
//            public void run() {
//                System.out.println("Hello world");
//                tick();
//                render();
//            }
//        };
//
//        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
//        executor.scheduleAtFixedRate(update, 0, 1, TimeUnit.SECONDS);
//        while (running){
//            System.out.println("Hello world");
//        }
//
//    }
//
//    public void update(){
//
//    }
//
//    public void paintComponent(Graphics g){
//
//    }

//    public void tick(){
//        tickCount++;
//
//        for (int i = 0; i < pixels.length; i++){
//            pixels[i] = i + tickCount;
//        }
//    }
//
//    public void render(){ //paintComponent
//        BufferStrategy bs = getBufferStrategy();
//        if (bs==null){
//            createBufferStrategy(3);
//            return;
//        }
//
//        Graphics g = bs.getDrawGraphics();
//
//        g.setColor(Color.BLACK);
//        g.fillRect(0, 0, getWidth(), getHeight());
//
//        g.drawImage(image, 0,0, getWidth(), getHeight(), null);
//
//        g.dispose();
//        bs.show();
//    }
         //Attempting to make part of scoreboard
//       public int ScoreDisplay(int Score){   
//            while(/*game is running*/) {
//                if(/*hit by zombie*/) {
//                    Score = Score - /*damage number*/;
//                }
//                if(/*gets syringe*/){
//                    Score += /*reward number*/;
//                }
//                if(/*gets gun*/){
//                    Score+= /*reward number*/;
//                }
//            }
//        return Score;
//        }

>>>>>>> 8b3ab9d8089877a1292f8a0310cbe4303784bf84

}

