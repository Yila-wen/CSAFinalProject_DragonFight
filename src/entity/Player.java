package entity;

import main.GamePanel;
import main.Movement;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import javax.imageio.ImageIO;

public class Player extends Entity{

    GamePanel gp;
    Movement move;

    public Player(GamePanel gp, Movement m){
        this.gp = gp;
        move = m;

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

        x = 50;
        y = 403;
        speed = 4;
        direction = "down"; // First Animation shown
    }


    public void update() {

        if(move.upPressed || move.downPressed || move.leftPressed || move.rightPressed){
            if (move.upPressed){
                // NEED TO BE CHANGE TO JUMP
                direction = "up";
                y -= speed;
            }
            else if (move.downPressed) {
                // NEED TO BE CHANGE TO DUCK
                direction = "down";
                y += speed;
            }
            else if (move.rightPressed) {

                direction = "right";
                x += speed;

            }
            else if (move.leftPressed){

                direction = "left";
                x -= speed;
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
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize,null);

    }
 // https://www.youtube.com/watch?v=ugzxCcpoSdE 9:11
}
