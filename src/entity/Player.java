package entity;

import main.GamePanel;
import main.Controls;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity{

    GamePanel gp;
    Controls input;
    public final int SCREENX;

    public final int SCREENY;
    public static boolean jump;
    public final int FLOORHEIGHT;
    private float jumpStrength, weight;

    public Player(GamePanel gp, Controls m){
        this.gp = gp;
        input = m;

        SCREENX = gp.screenWidth/2 - (gp.tileSize/2);
        SCREENY = gp.screenHeight/2 - (gp.tileSize/2);
        FLOORHEIGHT = gp.tileSize*40;

        setDefaultValues();
        getPlayerImage();
    }
    public void getPlayerImage(){
        try {

            // Change to IMAGE

            up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_up_1.png")));
            up2 =ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_up_2.png")));
            down1 =ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_down_1.png")));
            down2=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_down_2.png")));
            left1=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_left_1.png")));
            left2=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_left_2.png")));
            right1=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_right_1.png")));
            right2=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_right_2.png")));
            // This is calling the image from the player file ex package/filename


        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void setDefaultValues(){

        worldX = gp.tileSize*7;
        worldY = gp.tileSize*40;
        speed = 8;
        direction = "down"; // First Animation shown
        jump = false;
        weight = 3;

    }


    public void update() {

        // JUMP WIP

//        if (input.upPressed && worldY >= FLOORHEIGHT){
//            if (!jump){jumpStrength = 24;}
//            direction = "up";
//
//            new Thread(new jping()).start();
//            worldY -= jumpStrength;
//            jumpStrength -= weight;
//            System.out.println(jumpStrength);
//
//            if (worldY >= FLOORHEIGHT){worldY = FLOORHEIGHT;}

        if(input.upPressed || input.downPressed || input.leftPressed || input.rightPressed){

            if (input.upPressed ){
                direction = "up";

                worldY -= speed;

            }
            else if (input.downPressed) {
                // NEED TO BE CHANGE TO DUCK
                direction = "down";
                worldY += speed;
            }
            else if (input.rightPressed) {

                direction = "right";
                worldX += speed;

            }
            else if (input.leftPressed){

                direction = "left";
                worldX -= speed;
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
        }



    public void draw(Graphics2D g2){

//        g2.setColor(Color.white);
//        g2.fillRect(x,y,gp.tileSize,gp.tileSize);

        BufferedImage image = null;

        switch(direction) {
            case "up":
                if (spriteNum ==1){
                    image = up1;
                }
                if (spriteNum == 2){
                    image = up2;
                }
                break;
            case "down":
                if (spriteNum ==1){
                    image = down1;
                }
                if (spriteNum == 2){
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum ==1){
                    image = left1;
                }
                if (spriteNum == 2){
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum ==1){
                    image = right1;
                }
                if (spriteNum == 2){
                    image = right2;
                }
                break;
        }
        g2.drawImage(image, SCREENX, SCREENY, gp.tileSize, gp.tileSize,null);

    }
 // https://www.youtube.com/watch?v=ugzxCcpoSdE 9:11

//    public static class jping implements Runnable {
//
//        @Override
//        public void run() {
//            long jumpTime = 200;
//            try {
//                Thread.sleep(jumpTime);
//                entity.Player.jump = false;
//
//            } catch (Exception e) {
//                e.printStackTrace();
//                new Thread(this).start();
//                System.exit(0);``
//            }
//
//
//
//
//
//        }
//    }
}
