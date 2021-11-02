package com.ZombieW;

import com.ZombieW.graphics.Screen;
import com.ZombieW.graphics.SpriteSheet;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTreeUI;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Game extends Canvas{

    private static final long serialVersionUID = 1L;

    public static final int WIDTH = 160;
    public static final int HEIGHT = WIDTH / 12 * 9;
    public static final int SCALE = 3;
    public static final String NAME = "ZOMBIE";
    public int tickCount = 0;

    private JFrame frame;

    public boolean running = false;

    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();



    //private SpriteSheet spriteSheet = ne SpriteSheet("/sprite_sheet.png");
    //private Screen screen;

    //set player's defaullt position


    public Game(){
        //setMinimumSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
        //setMaximumSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
        //setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));

        frame = new JFrame(NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        frame.add(this, BorderLayout.CENTER);
        //frame.pack();

        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        GamePanel gamePanel = new GamePanel();
        frame.add(gamePanel);

        frame.pack();


    }

    //public void init() {
    //    screen = new Screen(WIDTH, HEIGHT, new SpriteSheet("/sprite_sheet.png"));
    //}

    public static void main(String[] args){
        //new Game().start();
        new Game();

    }

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


}

