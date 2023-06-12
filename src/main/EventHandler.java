package main;

import java.awt.*;

public class EventHandler {

    GamePanel gp;
    Rectangle eventRect;
    int eventRectDefaultX, eventRectDefaultY;

    public EventHandler(GamePanel gp){
        this.gp = gp;
        eventRect = new Rectangle(23,23,2,2);
        eventRectDefaultX = eventRect.x;
        eventRectDefaultY = eventRect.y;

    }

    public void checkEvent(){}

    public boolean hit(int eventRow, int eventCol){
        boolean hit = false;

        int hitboxDefaultX = gp.player.hitbox.x;
        int hitboxDefaultY = gp.player.hitbox.y;
        int eventRectDefaultX = eventRect.x;
        int eventRectDefaultY= eventRect.y;


        gp.player.hitbox.x = gp.player.worldX+gp.player.hitbox.x;
        gp.player.hitbox.y = gp.player.worldY+gp.player.hitbox.y;
        eventRect.x = eventCol*gp.tileSize + eventRect.x;
        eventRect.y = eventRow*gp.tileSize+eventRect.y;

        if (gp.player.hitbox.intersects(eventRect)){
            hit = true;
            }
        gp.player.hitbox.x=hitboxDefaultX;
        gp.player.hitbox.y=hitboxDefaultY;
        eventRect.x=eventRectDefaultX;
        eventRect.y=eventRectDefaultY;

        return  hit;
    }
}
