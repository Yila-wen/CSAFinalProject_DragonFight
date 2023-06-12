package entity;

import main.GamePanel;
import main.Controls;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity{

    Controls input;
    public final int SCREENX;

    public final int SCREENY;
    public  boolean jump;
    public boolean jDown;

    private float jumpStrength, weight;
    public HealthBar playerHP;

    public Player(GamePanel gp, Controls m){
        super(gp);
        input = m;

        SCREENX = gp.screenWidth/2 - (gp.tileSize/2);
        SCREENY = gp.screenHeight/2 - (gp.tileSize/2);


        hitbox = new Rectangle(16,16,gp.tileSize,gp.tileSize-(gp.tileSize/8));
        hitboxDefaultX = 16;
        hitboxDefaultY = 16;

        setDefaultValues();
        getPlayerImage();
    }
    public void getPlayerImage(){
            up1 = setup("/player/jump1",gp.tileSize+(gp.tileSize/4),gp.tileSize+(gp.tileSize/4));
            up2 =setup("/player/jump2",gp.tileSize+(gp.tileSize/4),gp.tileSize+(gp.tileSize/4));
            down1 =setup("/player/protect1",gp.tileSize+(gp.tileSize/4),gp.tileSize+(gp.tileSize/4));
            down2=setup("/player/protect2",gp.tileSize+(gp.tileSize/4),gp.tileSize+(gp.tileSize/4));
            left1=setup("/player/lRun1",gp.tileSize+(gp.tileSize/4),gp.tileSize+(gp.tileSize/4));
            left2=setup("/player/lRun2",gp.tileSize+(gp.tileSize/4),gp.tileSize+(gp.tileSize/4));
            right1=setup("/player/rRun1",gp.tileSize+(gp.tileSize/4),gp.tileSize+(gp.tileSize/4));
            right2=setup("/player/rRun2",gp.tileSize+(gp.tileSize/4),gp.tileSize+(gp.tileSize/4));
            attack1 = setup("/player/attack1",gp.tileSize+(gp.tileSize/2),gp.tileSize+(gp.tileSize/4));
            attack2 = setup("/player/attack2",gp.tileSize+(gp.tileSize/2),gp.tileSize+(gp.tileSize/4));
            // This is calling the image from the player file ex package/filename

    }

    public void setDefaultValues(){

        worldX = gp.tileSize*8;
        worldY = (gp.tileSize*19)-(gp.tileSize/4);
        speed = 20;
        direction = "right"; // First Animation shown
        playerHP = new HealthBar(gp.tileSize/2,gp.tileSize/2,150,25,100);


        jump = false;
        jDown = false;
        jumpStrength = 25;
        weight = 5;

    }


    public void update() {
        if (playerHP.getCurrentHealth() != 0){

        if (input.attackPressed && !attacking){
            attacking = true;
        }
        else if (attacking){
            attackAni();
        }
        else if (input.upPressed && !jump){
            jump = true;
            spriteCounter = 0;
            spriteNum = 1;
        }
        else if (jump){
            jumpAni();
        }
        else if (!jump && worldY< ((gp.tileSize*19)-gp.tileSize/4)){
            jDown = true;
            worldY+= 8;
            if (worldY >= ((gp.tileSize*19)-gp.tileSize/4)){
                worldY = ((gp.tileSize*19)-gp.tileSize/4);
                jDown = false;
            }
        }

        else if( input.downPressed || input.leftPressed || input.rightPressed|| input.heal){
            if (input.downPressed) {
                // NEED TO BE CHANGE TO DUCK
                direction = "down";
            }
            else if (input.rightPressed) {

                direction = "right";
            }
            else if (input.leftPressed) {

                direction = "left";
            } else if (input.heal) {
                direction = "heal";

            }

            collisionOn = false;
            gp.cc.checkTile(this);

            boolean entityCollided = gp.cc.checkEntity(this,gp.dragon);
            dragonInteraction(entityCollided);

            if (!collisionOn){
                switch (direction) {
                    case "down" -> worldY += speed;
                    case "left" -> worldX -= speed;
                    case "right" -> worldX += speed;
                    case "heal" -> System.out.println( playerHP.changeCurrentHealth(5,"+"));
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
        if (iframes){
            iframesCounter++;
            if (iframesCounter > 60){
                iframes = false;
                iframesCounter = 0;
            }
        }

        }
        else gp.gameState = gp.DEAD_STATE;

    }

        public void attackAni(){
         spriteCounter++;
         if (spriteCounter <= 5){
             spriteNum = 1;
         }
         if (spriteCounter >5 && spriteCounter <= 25){
             spriteNum = 2;
         }
         if (spriteCounter >25){
             spriteNum = 1;
             spriteCounter = 0;
             attacking = false;
         }

        }

        public void jumpAni(){
        spriteCounter++;
            if (spriteCounter <= 6){
                System.out.println(jumpStrength);
                spriteNum = 1;
                worldY-=jumpStrength;
                jumpStrength-=weight;

            }
            if (spriteCounter == 7){
                jumpStrength = 0;
            }
            if (spriteCounter >8 && spriteCounter <= 14){
                System.out.println(jumpStrength);
                spriteNum = 2;
                jumpStrength -= weight;
                worldY += jumpStrength;

            }
            if (spriteCounter >=15){
                spriteNum = 1;
                spriteCounter = 0;
                jumpStrength = 25;
                jump = false;

            }


        }



    public void draw(Graphics2D g2){

//        g2.setColor(Color.white);
//        g2.fillRect(x,y,gp.tileSize,gp.tileSize);

        BufferedImage image = null;

        if (!attacking){
            if (jump){
                if (spriteNum == 1){image = up1;}
                if (spriteNum == 2){image = up2;}
            }
            if (jDown){
                image = up2;
            }
            else
        switch (direction) {
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
        }
        else if (attacking){
            if (spriteNum == 1){image = attack1;}
            if (spriteNum == 2){image = attack2;}
        }
        g2.drawImage(image, SCREENX, SCREENY,null);

    }

    public void dragonInteraction(boolean x){

        if (x){
            if (!iframes){
            playerHP.changeCurrentHealth(25,"-");
            iframes = true;
        }
        }

    }

}
