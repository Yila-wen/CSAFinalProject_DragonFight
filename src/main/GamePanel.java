package main;

import entity.Entity;
import entity.Player;
import tiles.TileManager;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class GamePanel extends JPanel implements Runnable{

    // SCREEN SETTINGS
    final int ORIGINAL_TILE_SIZE = 16;
    final int SCALE = 4;

    public final int TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE;
    public final int MAX_SCREEN_COL = 16;
    public final int MAX_SCREEN_ROW = 12;
    public final int SCREEN_WIDTH = TILE_SIZE * MAX_SCREEN_COL; // 768 pixel
    public final int SCREEN_HEIGHT = TILE_SIZE * MAX_SCREEN_ROW; // 576 pixel

    public final int MAX_WORLD_COL = 52;
    public final int MAX_WORLD_ROW = 26;
    public final int worldWidth = TILE_SIZE * MAX_WORLD_COL;
    public final int worldHeight = TILE_SIZE * MAX_WORLD_ROW;

    public final int FPS = 60;
    TileManager tileM = new TileManager(this);
    Controls input = new Controls(this);
    // Thread keeps the program running until we stop it
    Thread gameThread;
    AssetSetter aSetter = new AssetSetter(this);
    public Player player = new Player(this,input);
    //  public Dragon dragon = new Dragon(this);
    // MAYBE USE^
    public Entity[] dragon = new Entity[1];
    public Display ui = new Display(this);
    public EventHandler eHandler = new EventHandler(this);


    public int gameState;
    public final int TITLE_STATE = 0;
    public final int PLAY_STATE = 1;
    public final int PAUSE_STATE = 2;
    public final int DEAD_STATE = 3;
    public CollisionChecker cc = new CollisionChecker(this);


    public GamePanel(){

        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground((Color.black));
        this.setDoubleBuffered(true);
        this.addKeyListener(input);
        this.setFocusable(true);


    }

    public void setUpGame(){
        aSetter.setDragon();
        gameState = TITLE_STATE;
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

        if (gameState == PLAY_STATE ){
        player.update();
        dragon[0].update();

        }
        else if (gameState == PAUSE_STATE){


        }
        else if (gameState == DEAD_STATE){


        }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        if (gameState == TITLE_STATE){
            ui.draw(g2);
        }
        else {
            tileM.draw(g2);

            dragon[0].draw(g2);

            player.draw(g2);
//            if (dragon[0] != null){
//                dragon[0].draw(g2);
//            }

            ui.draw(g2);

        }


        g2.dispose();


    }

    public void saveData(){

        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/SavedGame.txt"));
            bw.write(""+player.playerHP.getCurrentHealth());
            bw.newLine();
            bw.write(""+player.worldX);
            bw.newLine();
            bw.write(""+player.worldY);
            bw.newLine();
            bw.write(""+player.direction);

            bw.close();


        }catch (IOException e){

        }
    }

    public void loadData(){

        try{
            BufferedReader br = new BufferedReader(new FileReader("src/main/SavedGame.txt"));
            player.playerHP.setCurrentHealth(Integer.parseInt(br.readLine()));
            player.worldX = Integer.parseInt(br.readLine());
            player.worldY = Integer.parseInt(br.readLine());
            player.direction = br.readLine();

            br.close();


        }catch (IOException e){

        }

    }

}
