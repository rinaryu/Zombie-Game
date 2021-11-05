package com.ZombieW;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {

    public boolean up, down, left, right;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W){
            up = true;
            System.out.println("pressed up");
        }
        if (code == KeyEvent.VK_S){
            down = true;
            System.out.println("pressed up");
        }
        if (code == KeyEvent.VK_A){
            left = true;
            System.out.println("pressed up");
        }
        if (code == KeyEvent.VK_D){
            right = true;
            System.out.println("pressed up");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W){
            up = false;
            //System.out.println("pressed up");
        }
        if (code == KeyEvent.VK_S){
            down = false;
            //System.out.println("pressed up");
        }
        if (code == KeyEvent.VK_A){
            left = false;
            //System.out.println("pressed up");

        }
        if (code == KeyEvent.VK_D){
            right = false;
            //System.out.println("pressed up");

        }
    }
}
