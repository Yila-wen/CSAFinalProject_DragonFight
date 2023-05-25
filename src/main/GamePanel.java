package main;

import entity.Player;
import tiles.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    // SCREEN SETTINGS
    final int originalTileSize = 16;
    final int scale = 3;

    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; // 768 pixel
    public final int screenHeight = tileSize * maxScreenRow; // 576 pixel

    public final int maxWorldCol = 50;
    public final int maxWorldRow = 46;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    public final int FPS = 60;
    TileManager tileM = new TileManager(this);
    Movement move = new Movement();
    // Thread keeps the program running until we stop it
    Thread gameThread;
    public Player player = new Player(this,move);



    public GamePanel(){

        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground((Color.black));
        this.setDoubleBuffered(true);
        this.addKeyListener(move);
        this.setFocusable(true);
    }

    public void startGameThread(){

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override //Game Loop (Core of Game)
    public void run() {

        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while(gameThread != null) {

            currentTime = System.nanoTime(); //Checks CurrentTime
            delta += (currentTime - lastTime) / drawInterval; //Checks how much time Passed
            timer += (currentTime - lastTime);
            lastTime = currentTime;


            if(delta >= 1){
                update();
                repaint();
                delta--;
                drawCount++;
            }
            //Checks FPS
            if (timer >= 1000000000){
                //System.out.println("FPS: "+drawCount);
                drawCount = 0;
                timer = 0;
            }


        }


    }

    public void update() {

        player.update();
    }
    public void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        tileM.draw(g2);
        player.draw(g2);


        g2.dispose();


    }

}
