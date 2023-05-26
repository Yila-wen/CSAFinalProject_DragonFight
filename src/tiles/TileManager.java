package tiles;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class TileManager {
    GamePanel gp;
    Tile[] tile;
    int[][] mapTileNum;

    public TileManager(GamePanel gp) {

        this.gp = gp;

        tile = new Tile[10];
        mapTileNum = new int[gp.maxWorldRow][gp.maxWorldCol];

        getTileImage();
        loadMap();
    }
        public void getTileImage(){
        try{
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/GrassTile.png")));
            tile[0].collision = true;
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/DirtTile.png")));
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/StoneTile.png")));
            tile[2].collision = true;
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/SkyTile.png")));

        }catch (IOException e){
            e.printStackTrace();
        }
        }
        public void loadMap(){

        try {
            InputStream is = getClass().getResourceAsStream("/maps/map.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col < gp.maxWorldCol && row < gp.maxWorldRow){
                String line = br.readLine();
                while(col < gp.maxWorldCol){
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[row][col] = num;
                    col++;
                }
                if (col == gp.maxWorldCol){
                    col = 0;
                    row++;
                }
            }
            br.close();

        }catch (Exception e){

        }

        }


        // FINISH
        public void draw(Graphics2D g2){

        int col =0;
        int row =0;

        while(col < gp.maxWorldCol && row < gp.maxWorldRow){
            int tileNum = mapTileNum[row][col];
            int worldX = col * gp.tileSize;
            int worldY = row * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.SCREENX;
            int screenY = worldY - gp.player.worldY + gp.player.SCREENY;

            if(worldX+gp.tileSize> gp.player.worldX - gp.player.SCREENX && worldX-gp.tileSize < gp.player.worldX + gp.player.SCREENX &&
            worldY+gp.tileSize > gp.player.worldY - gp.player.SCREENY && worldY-gp.tileSize < gp.player.worldY + gp.player.SCREENY){
                g2.drawImage(tile[tileNum].image,screenX,screenY,gp.tileSize,gp.tileSize,null);
            }

            col++;

            if(col == gp.maxWorldCol){
                col =0;
                row++;
            }
        }

        }




    }
