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
    public Tile[] tile;
    public int[][] mapTileNum;

    public TileManager(GamePanel gp) {

        this.gp = gp;

        tile = new Tile[10];
        mapTileNum = new int[gp.MAX_WORLD_ROW][gp.MAX_WORLD_COL];

        getTileImage();
        loadMap();
    }
        public void getTileImage(){
            setup(0,"GrassTile",true);
            setup(1,"DirtTile",true);
            setup(2,"StoneTile",true);
            setup(3,"SkyTile",false);
            setup(4,"PurpleTile",true);

        }

        public void setup(int index,String imagePath,boolean collision){

        Scaler scale =new Scaler();

        try {
            tile[index] = new Tile();
            tile[index].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/"+imagePath+".png")));
            tile[index].image = scale.scaleImage(tile[index].image,gp.TILE_SIZE,gp.TILE_SIZE);
            tile[index].collision = collision;
        }catch (IOException e){e.printStackTrace();}
        }

        public void loadMap(){

        try {
            InputStream is = getClass().getResourceAsStream("/maps/map.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col < gp.MAX_WORLD_COL && row < gp.MAX_WORLD_ROW){
                String line = br.readLine();
                while(col < gp.MAX_WORLD_COL){
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[row][col] = num;
                    col++;
                }
                if (col == gp.MAX_WORLD_COL){
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

        while(col < gp.MAX_WORLD_COL && row < gp.MAX_WORLD_ROW){
            int tileNum = mapTileNum[row][col];
            int worldX = col * gp.TILE_SIZE;
            int worldY = row * gp.TILE_SIZE;
            int screenX = worldX - gp.player.worldX + gp.player.SCREENX;
            int screenY = worldY - gp.player.worldY + gp.player.SCREENY;

            if(worldX+gp.TILE_SIZE > gp.player.worldX - gp.player.SCREENX && worldX-gp.TILE_SIZE < gp.player.worldX + gp.player.SCREENX &&
            worldY+gp.TILE_SIZE > gp.player.worldY - gp.player.SCREENY && worldY-gp.TILE_SIZE < gp.player.worldY + gp.player.SCREENY){
                g2.drawImage(tile[tileNum].image,screenX,screenY,gp.TILE_SIZE,gp.TILE_SIZE,null);
            }

            col++;

            if(col == gp.MAX_WORLD_COL){
                col =0;
                row++;
            }
        }

        }




    }
