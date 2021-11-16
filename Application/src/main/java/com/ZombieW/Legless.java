package com.ZombieW;

import javax.imageio.ImageIO;
import java.io.IOException;

class Legless extends Zombie{
    public Legless(GamePanel gp, MainCharacter mc){
        super(gp, mc);
    }
    public void getZombieImage() {
        try {

            sprite = ImageIO.read(getClass().getResourceAsStream("/leglessZombie.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}