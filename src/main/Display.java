package main;

import tiles.Scaler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Display {


    GamePanel gp;
    Graphics2D g2;
    public int cmdNum;



    public Display(GamePanel gp){
        this.gp = gp;
        cmdNum = 0;
    }


    public void draw(Graphics2D g2) {
        this.g2 = g2;
        g2.setFont(g2.getFont().deriveFont(Font.ITALIC));
        g2.setColor(Color.black);

        if (gp.gameState == gp.TITLE_STATE){
            drawTitleScreen();
        }
        if (gp.gameState == gp.PLAY_STATE){
            gp.player.playerHP.draw(g2);


        }
        if (gp.gameState == gp.PAUSE_STATE){
            drawPauseScreen();
        }
        if (gp.gameState == gp.DEAD_STATE){
            drawLoseScreen();
        }
    }


    public void drawTitleScreen() {
        // PREP
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 60F));
        String text = "Knigon";
        int length = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        int x = (gp.SCREEN_WIDTH /2) - length/2;
        int y = gp.TILE_SIZE +(gp.TILE_SIZE /2);


        // Title Image
        BufferedImage title = setup("titleScreen", "title");
        g2.drawImage(title,0,0,null);

        // Title
        g2.setColor(Color.black);
        g2.drawString(text,x+5,y+5);
        g2.setColor(Color.orange);
        g2.drawString(text,x,y);

        //Menu
        g2.setFont(g2.getFont().deriveFont(28F));
        text = "NEW GAME";
        x = (gp.SCREEN_WIDTH /2)-(gp.TILE_SIZE *3)+ gp.TILE_SIZE /2;
        y = gp.TILE_SIZE *4;
        g2.setColor(Color.GRAY);
        g2.drawString(text,x+5,y+5);
        g2.setColor(Color.white);
        g2.drawString(text,x,y);
        if (cmdNum == 0){
            g2.setColor(Color.black);
            g2.drawString(">",x-(gp.TILE_SIZE /2),y);
        }

        g2.setFont(g2.getFont().deriveFont(28F));
        g2.setColor(Color.white);
        text = "LOAD GAME";
        x = (gp.SCREEN_WIDTH /2)-(gp.TILE_SIZE *3)+ gp.TILE_SIZE /2;
        y += gp.TILE_SIZE *2;
        g2.setColor(Color.GRAY);
        g2.drawString(text,x+5,y+5);
        g2.setColor(Color.white);
        g2.drawString(text,x,y);
        if (cmdNum == 1){
            g2.setColor(Color.black);
            g2.drawString(">",x-(gp.TILE_SIZE /2),y);
        }

        g2.setFont(g2.getFont().deriveFont(28F));
        g2.setColor(Color.white);
        text = "QUIT";
        x = (gp.SCREEN_WIDTH /2)-(gp.TILE_SIZE *3)+ gp.TILE_SIZE /2;
        y += gp.TILE_SIZE *2;
        g2.setColor(Color.GRAY);
        g2.drawString(text,x+5,y+5);
        g2.setColor(Color.white);
        g2.drawString(text,x,y);
        if (cmdNum == 2){
            g2.setColor(Color.black);
            g2.drawString(">",x-(gp.TILE_SIZE /2),y);
        }




    }

    public void drawPauseScreen(){
        g2.setFont(g2.getFont().deriveFont(Font.ITALIC,80F));
        String text = "PAUSED";
        int length = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        int x = (gp.SCREEN_WIDTH /2) - length/2;
        int y = (gp.SCREEN_HEIGHT /3);
        g2.drawString(text,x,y);

        // Options
        g2.setFont(g2.getFont().deriveFont(28F));
        text = "SAVE GAME";
        x = (gp.SCREEN_WIDTH /2)-(gp.TILE_SIZE *3)+ gp.TILE_SIZE /2;
        y = gp.TILE_SIZE *6;
        g2.setColor(Color.white);
        g2.drawString(text,x+5,y+5);
        if (cmdNum == 0){
            g2.setColor(Color.black);
            g2.drawString(">",x-(gp.TILE_SIZE /2),y);
        }
        g2.setFont(g2.getFont().deriveFont(28F));
        g2.setColor(Color.white);
        text = "BACK";
        x = (gp.SCREEN_WIDTH /2)-(gp.TILE_SIZE *3)+ gp.TILE_SIZE /2;
        y += gp.TILE_SIZE *2;
        g2.setColor(Color.white);
        g2.drawString(text,x,y);
        if (cmdNum == 1){
            g2.setColor(Color.black);
            g2.drawString(">",x-(gp.TILE_SIZE /2),y);
        }
    }

    public void drawLoseScreen(){

        g2.setFont(g2.getFont().deriveFont(Font.ITALIC,80F));
        g2.setColor(Color.red);
        String text = "YOU DIED";
        int length = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        int x = (gp.SCREEN_WIDTH /2) - length/2;
        int y = (gp.SCREEN_HEIGHT /3);
        g2.drawString(text,x,y);


    }



    public BufferedImage setup(String imageName, String location){
        Scaler scale = new Scaler();
        BufferedImage scaledImage = null;

        try {
            scaledImage = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/"+ location  +"/"+imageName +".png")));
            scaledImage = scale.scaleImage(scaledImage,gp.SCREEN_WIDTH,gp.SCREEN_HEIGHT); //may need to be changed to fit other criterias
        }catch (IOException e){e.printStackTrace();}
        return scaledImage;

    }


    }





