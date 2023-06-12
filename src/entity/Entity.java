package entity;

import main.GamePanel;
import tiles.Scaler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Entity {
    GamePanel gp;
    public int worldX,worldY;
    public int speed;
    public BufferedImage up1,up2,down1,down2,left1,left2,right1,right2, attack1, attack2,pAttack1,pAttack2;
    public String direction;

    public int spriteCounter;
    public int spriteNum;
    boolean attacking;
    public Rectangle hitbox;
    public int hitboxDefaultX;
    public int hitboxDefaultY;
    public boolean collisionOn;
    public int actionCounter;
    public boolean iframes;
    public int iframesCounter;
    public int type;


    public Entity(GamePanel gp){
        this.gp=gp;
        spriteCounter = 0;
        spriteNum = 1;
        attacking = false;
        actionCounter = 0;
        collisionOn = false;
        iframes = false;
        iframesCounter = 0;
    }

    public void draw(Graphics2D g2){

        BufferedImage image = null;

        int screenX = worldX - gp.player.worldX + gp.player.SCREENX;
        int screenY = worldY - gp.player.worldY + gp.player.SCREENY;

        if (worldX + gp.TILE_SIZE > gp.player.worldX - gp.player.SCREENX &&
                worldX - gp.TILE_SIZE < gp.player.worldX + gp.player.SCREENX &&
                worldY + gp.TILE_SIZE > gp.player.worldY - gp.player.SCREENY &&
                worldY - gp.TILE_SIZE < gp.player.worldY + gp.player.SCREENY){

            switch (direction) {
                case "up" -> {
                    if (spriteNum == 1) {
                        image = up1;
                    }
                    if (spriteNum == 2) {
                        image = up2;
                    }
                }
                case "down" -> {
                    if (spriteNum == 1) {
                        image = down1;
                    }
                    if (spriteNum == 2) {
                        image = down2;
                    }
                }
                case "left" -> {
                    if (spriteNum == 1) {
                        image = left1;
                    }
                    if (spriteNum == 2) {
                        image = left2;
                    }
                }
                case "right" -> {
                    if (spriteNum == 1) {
                        image = right1;
                    }
                    if (spriteNum == 2) {
                        image = right2;
                    }
                }

            }


            g2.drawImage(image,screenX,screenY,gp.TILE_SIZE *5,gp.TILE_SIZE *5,null);
        }

    }

    public void setAction(){}
    public void update(){

        setAction();

        collisionOn = false;
        gp.cc.checkTile(this);
        boolean pContact = gp.cc.checkPlayer(this);

        if (this.type == 1 && pContact){
            if (!gp.player.iframes){
                gp.player.playerHP.changeCurrentHealth(10,"-");
                gp.player.iframes = true;
            }
        }

        if (!collisionOn){

            switch (direction) {
                case "up" -> worldY -= speed;
                case "down" -> worldY += speed;
                case "left" -> worldX -= 4;
                case "right" -> worldX += speed;

            }
        }

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


    public BufferedImage setup(String imagePath,int width,int height){
        Scaler scale = new Scaler();
        BufferedImage scaledImage = null;

        try {
            scaledImage = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(imagePath +".png")));
            scaledImage = scale.scaleImage(scaledImage,width,height);
        }catch (IOException e){e.printStackTrace();}
        return scaledImage;

    }


}
