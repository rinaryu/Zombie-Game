package com.ZombieW;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class GridManager {
    GamePanel gp;
    Grid[] grids;
    int mapGridNum[][];

    public GridManager(GamePanel gp){
        this.gp = gp;
        grids = new Grid[10];
        mapGridNum = new int[gp.maxScreenCol][gp.maxScreenRow];

        getGridImage();
        populateMap();
    }
    public int[][] getMapGridNum(){
        return mapGridNum;
    }

    /**
     *
     */
    public void getGridImage(){
        try{
            grids[0] = new Grid();
            grids[1] = new Grid();
            grids[0].image = ImageIO.read(getClass().getResourceAsStream("/fllor.png"));
            grids[1].image = ImageIO.read(getClass().getResourceAsStream("/all.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     *
     */
    private void populateMap(){
        try {
            InputStream is = getClass().getResourceAsStream("/tempMap.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < gp.maxScreenCol && row < gp.maxScreenRow){
                String line = br.readLine();

                while (col < gp.maxScreenCol){
                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapGridNum[col][row] = num;
                    col++;
                }
                if (col == gp.maxScreenCol){
                    col = 0;
                    row++;
                }
            }
            br.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     *
     * @param g2
     */
    public void draw(Graphics2D g2){
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while (col < gp.maxScreenCol && row < gp.maxScreenRow){
            int gridType = mapGridNum[col][row];
            g2.drawImage(grids[gridType].image, x, y, gp.tileSize, gp.tileSize, null);
            col++;
            x += gp.tileSize;

            if (col == gp.maxScreenCol){
                col = 0;
                x = 0;
                row++;
                y += gp.tileSize;
            }
        }
    }
}
