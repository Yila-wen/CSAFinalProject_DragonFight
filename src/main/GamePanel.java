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
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; // 1680 pixel
    final int screenHeight = tileSize * maxScreenRow; // 1056 pixel

    int FPS = 60;
    TileManager tileM = new TileManager(this);
    Movement move = new Movement();
    // Thread keeps the program running until we stop it
    Thread gameThread;
    Player player = new Player(this,move);



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
                System.out.println("FPS: "+drawCount);
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

        Graphics2D g4 = (Graphics2D)g;
        Graphics2D g3 = (Graphics2D)g;


        Graphics2D g2 = (Graphics2D)g;

        tileM.draw(g2);
        player.draw(g2);

//        g3.setColor(Color.lightGray);
//        g3.fillRect(0,450,1000,120);


        g4.setColor(Color.cyan);
        g4.fillOval(400,50,100,tileSize);




        g2.dispose();
//        g3.dispose();
//        g4.dispose();

    }

}
