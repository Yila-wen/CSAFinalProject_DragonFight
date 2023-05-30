package entity;

import main.Controls;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Dragon extends Entity{

    GamePanel gp;

    public int speed;





    public Dragon(GamePanel gp){
        this.gp = gp;





        setDragonDefaultValues();
        getDragonPlayerImage();
    }

    public void setDragonDefaultValues(){
        worldX = (gp.tileSize * gp.maxWorldCol)- (gp.tileSize*4);
        worldY = (gp.tileSize * 40);



    }

    public void getDragonPlayerImage(){
        try {

            // Change to DRAGON IMAGE

            dIdle1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/dragon/DIdle1.png")));
            dIdle2 =ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/dragon/DIdle2.png")));

            // This is calling the image from the player file ex package/filename


        }catch(IOException e){
            e.printStackTrace();
        }




    }
    public void update() {



                spriteCounter++;
                if(spriteCounter > 12){
                    if(spriteNum == 1){
                        spriteNum = 2;
                    }
                    else if (spriteNum == 2){
                        spriteNum = 1;
                    }
                    spriteCounter = 0;
                }
            }

    public void draw(Graphics2D g2,int x,int y){




        BufferedImage image = null;

                if (spriteNum ==1){
                    image = dIdle1;

                }
                if (spriteNum == 2){
                    image = dIdle2;

                }

        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize,null);

    }


    }



