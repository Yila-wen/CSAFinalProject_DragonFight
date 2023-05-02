package entity;

import main.GamePanel;
import main.Movement;

import java.awt.*;

public class Player extends Entity{

    GamePanel gp;
    Movement move;

    public Player(GamePanel gp, Movement m){
        this.gp = gp;
        move = m;
    }

    public void setDefaultValues(){

        x = 100;
        y = 100;
        speed = 4;
    }

    public void update() {

        if (move.upPressed){
            // NEED TO BE CHANGE TO JUMP
            y -= speed;
        }
        else if (move.downPressed) {
            // NEED TO BE CHANGE TO DUCK
            y += speed;
        }
        else if (move.rightPressed) {

            x += speed;

        }
        else if (move.leftPressed){

            x -= speed;
        }


    }
    public void draw(Graphics2D g2){

        g2.setColor(Color.white);

        g2.fillRect(x,y,gp.tileSize,gp.tileSize);

    }
    // https://www.youtube.com/watch?v=wT9uNGzMEM4&t=12s 6:35
}
