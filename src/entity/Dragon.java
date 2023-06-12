package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class Dragon extends Entity{
    public int speed;
    public HealthBar dragonHP;


    public Dragon(GamePanel gp){
        super(gp);

        type = 1;

        setDragonDefaultValues();
        getDragonImage();

    }

    public void setDragonDefaultValues(){
        speed = 8;
        direction = "down";
        dragonHP = new HealthBar(0,0,0,0,250);
        hitbox = new Rectangle(gp.tileSize*2+32,gp.tileSize,gp.tileSize*2,gp.tileSize*2 + gp.tileSize/2);
        hitboxDefaultX = gp.tileSize*2+32;
        hitboxDefaultY = gp.tileSize;

    }

    public void getDragonImage() {
        down1 = setup("/dragon/down1",gp.tileSize*10,gp.tileSize*10);
        down2 = setup("/dragon/down2",gp.tileSize*10,gp.tileSize*10);
        up1 = setup("/dragon/up1",gp.tileSize*10,gp.tileSize*10);
        up2 = setup("/dragon/up2",gp.tileSize*10,gp.tileSize*10);
        left1 = setup("/dragon/walk1",gp.tileSize*10,gp.tileSize*10);
        left2 = setup("/dragon/walk2",gp.tileSize*10,gp.tileSize*10);
        right1 = setup("/dragon/down1",gp.tileSize*10,gp.tileSize*10);
        right2 = setup("/dragon/down2",gp.tileSize*10,gp.tileSize*10);
        attack1 = setup("/dragon/attack1",gp.tileSize*10,gp.tileSize*10);
        attack2= setup("/dragon/attack2",gp.tileSize*10,gp.tileSize*10);


    }

    public void setAction(){

        actionCounter ++;

        if (actionCounter == 54) {

            Random random = new Random();
            int i = random.nextInt(100) + 1;

            if (i <= 8) {
                direction = "up";
            }
            if (i > 8 && i <= 28) {
                direction = "down";
            }
            if (i > 28 && i <= 38) {
                direction = "left";
            }
            if (i > 38 && i <= 54) {
                direction = "right";
            }

            actionCounter = 0;


        }



    }



    }



