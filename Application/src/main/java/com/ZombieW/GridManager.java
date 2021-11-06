package com.ZombieW;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class GridManager {
    GamePanel gp;
    Grid[] grids;

    public GridManager(GamePanel gp){
        this.gp = gp;
        grids = new Grid[10];
        getGridImage();
    }

    public void getGridImage(){
        try{
            for (int i = 0; i<=9; i++){
                grids[i] = new Grid();
                grids[i].image = ImageIO.read(getClass().getResourceAsStream("/fllor.png"));
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2){
        g2.drawImage(grids[0].image, 0, 0, gp.tileSize, gp.tileSize, null);
    }
}
