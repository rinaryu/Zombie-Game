package com.ZombieW;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 *Class which contains how the player will move up, down, left, and right.
 *contains two sub classes which allow this to work.
 */
public class KeyInput implements KeyListener {

    public boolean up, down, left, right, check;

    @Override
    public void keyTyped(KeyEvent e) {
    }
    /**
     * This class is used for when a key is pressed and allows the character to move.
     * You move up using W, down used S, left using A, and right using D.
     * Class also changes the boolean value assigned to being true, so the player can move.
     * @param e The key which is pressed to tell player which direction to move.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W){
            up = true;
        }
        if (code == KeyEvent.VK_S){
            down = true;
        }
        if (code == KeyEvent.VK_A){
            left = true;
        }
        if (code == KeyEvent.VK_D){
            right = true;
        }
        if (code == KeyEvent.VK_F){
            check = true;
        }
    }
    /**
     * This class is used for when the key that is pressed is released 
     * Once the key is released the player will stop going in that direction
     * Also changes the boolean value of the assigned keys to false for them to stop
     * @param e The key pressed which tells the player which way to move
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W){
            up = false;
        }
        if (code == KeyEvent.VK_S){
            down = false;
        }
        if (code == KeyEvent.VK_A){
            left = false;

        }
        if (code == KeyEvent.VK_D){
            right = false;

        }
        if (code == KeyEvent.VK_F){
            check = false;
        }
    }
}
