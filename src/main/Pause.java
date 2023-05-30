package main;

import javax.swing.*;
import java.awt.*;

public class Pause{


    GamePanel gp;
    Graphics2D g2;



    public Pause(GamePanel gp){
        this.gp = gp;


    }


    public void draw(Graphics2D g2) {
        this.g2 = g2;
        g2.setColor(Color.BLACK);

        if (gp.gameState == gp.playState){}
        if (gp.gameState == gp.pauseState){
            String text = "PAUSED";
            int x = (gp.screenWidth/2) - text.length();
            int y = (gp.screenHeight/2 - text.length());
            g2.drawString(text,x,y);

        }


    }





}
