package entity;

import main.GamePanel;

import java.awt.*;
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
        hitbox = new Rectangle(gp.TILE_SIZE *2+32,gp.TILE_SIZE,gp.TILE_SIZE *2,gp.TILE_SIZE *2 + gp.TILE_SIZE /2);
        hitboxDefaultX = gp.TILE_SIZE *2+32;
        hitboxDefaultY = gp.TILE_SIZE;

    }

    public void getDragonImage() {
        down1 = setup("/dragon/down1",gp.TILE_SIZE *10,gp.TILE_SIZE *10);
        down2 = setup("/dragon/down2",gp.TILE_SIZE *10,gp.TILE_SIZE *10);
        up1 = setup("/dragon/up1",gp.TILE_SIZE *10,gp.TILE_SIZE *10);
        up2 = setup("/dragon/up2",gp.TILE_SIZE *10,gp.TILE_SIZE *10);
        left1 = setup("/dragon/walk1",gp.TILE_SIZE *10,gp.TILE_SIZE *10);
        left2 = setup("/dragon/walk2",gp.TILE_SIZE *10,gp.TILE_SIZE *10);
        right1 = setup("/dragon/down1",gp.TILE_SIZE *10,gp.TILE_SIZE *10);
        right2 = setup("/dragon/down2",gp.TILE_SIZE *10,gp.TILE_SIZE *10);
        attack1 = setup("/dragon/attack1",gp.TILE_SIZE *10,gp.TILE_SIZE *10);
        attack2= setup("/dragon/attack2",gp.TILE_SIZE *10,gp.TILE_SIZE *10);


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



