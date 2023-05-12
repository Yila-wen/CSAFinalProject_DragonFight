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
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/DirtTile.png")));
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/StoneTile.png")));
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

            g2.drawImage(tile[1].image,0,448,gp.tileSize,gp.tileSize,null);
            g2.drawImage(tile[1].image,48,448,gp.tileSize,gp.tileSize,null);
            g2.drawImage(tile[1].image,96,448,gp.tileSize,gp.tileSize,null);
            g2.drawImage(tile[1].image,144,448,gp.tileSize,gp.tileSize,null);
            g2.drawImage(tile[1].image,192,448,gp.tileSize,gp.tileSize,null);
            g2.drawImage(tile[1].image,240,448,gp.tileSize,gp.tileSize,null);
            g2.drawImage(tile[1].image,288,448,gp.tileSize,gp.tileSize,null);
            g2.drawImage(tile[1].image,336,448,gp.tileSize,gp.tileSize,null);
            g2.drawImage(tile[1].image,384,448,gp.tileSize,gp.tileSize,null);
            g2.drawImage(tile[1].image,0,496,gp.tileSize,gp.tileSize,null);
            g2.drawImage(tile[1].image,48,496,gp.tileSize,gp.tileSize,null);
            g2.drawImage(tile[1].image,96,496,gp.tileSize,gp.tileSize,null);
            g2.drawImage(tile[1].image,144,496,gp.tileSize,gp.tileSize,null);
            g2.drawImage(tile[1].image,192,496,gp.tileSize,gp.tileSize,null);
            g2.drawImage(tile[1].image,240,496,gp.tileSize,gp.tileSize,null);
            g2.drawImage(tile[1].image,288,496,gp.tileSize,gp.tileSize,null);
            g2.drawImage(tile[1].image,336,496,gp.tileSize,gp.tileSize,null);
            g2.drawImage(tile[1].image,384,496,gp.tileSize,gp.tileSize,null);
            g2.drawImage(tile[1].image,0,520,gp.tileSize,gp.tileSize,null);
            g2.drawImage(tile[1].image,48,520,gp.tileSize,gp.tileSize,null);
            g2.drawImage(tile[1].image,96,520,gp.tileSize,gp.tileSize,null);
            g2.drawImage(tile[1].image,144,520,gp.tileSize,gp.tileSize,null);
            g2.drawImage(tile[1].image,192,520,gp.tileSize,gp.tileSize,null);
            g2.drawImage(tile[1].image,240,520,gp.tileSize,gp.tileSize,null);
            g2.drawImage(tile[1].image,288,520,gp.tileSize,gp.tileSize,null);
            g2.drawImage(tile[1].image,336,520,gp.tileSize,gp.tileSize,null);
            g2.drawImage(tile[1].image,384,520,gp.tileSize,gp.tileSize,null);

            g2.drawImage(tile[2].image,432,448,gp.tileSize,gp.tileSize,null);

        }

    }
