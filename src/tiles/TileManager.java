package tiles;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class TileManager {
    GamePanel gp;
    Tile[] tile;

    public TileManager(GamePanel gp) {

        this.gp = gp;

        tile = new Tile[10];

        getTileImage();
    }
        public void getTileImage(){
        try{
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/GrassTile.png")));
        }catch (IOException e){
            e.printStackTrace();
        }
        }

        // FINISH
        public void draw(Graphics2D g2){

        g2.drawImage(tile[0].image,0,400,gp.tileSize,gp.tileSize,null);
            g2.drawImage(tile[0].image,48,400,gp.tileSize,gp.tileSize,null);
            g2.drawImage(tile[0].image,96,400,gp.tileSize,gp.tileSize,null);
            g2.drawImage(tile[0].image,144,400,gp.tileSize,gp.tileSize,null);
            g2.drawImage(tile[0].image,192,400,gp.tileSize,gp.tileSize,null);
            g2.drawImage(tile[0].image,240,400,gp.tileSize,gp.tileSize,null);
            g2.drawImage(tile[0].image,288,400,gp.tileSize,gp.tileSize,null);
            g2.drawImage(tile[0].image,336,400,gp.tileSize,gp.tileSize,null);
            g2.drawImage(tile[0].image,384,400,gp.tileSize,gp.tileSize,null);
            g2.drawImage(tile[0].image,432,400,gp.tileSize,gp.tileSize,null);
        }

    }
