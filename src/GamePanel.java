import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    // SCREEN SETTINGS
    final int originalTileSize = 16;
    final int scale = 3;

    final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; // 1680 pixel
    final int screenHeight = tileSize * maxScreenRow; // 1056 pixel

    // Thread keeps the program running until we stop it
    Thread gameThread;

    public GamePanel(){

        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground((Color.black));
        this.setDoubleBuffered(true);
    }

    public void startGameThread(){

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override //Game Loop (Core of Game)
    public void run() {

        while(gameThread != null) {

        //    System.out.println("X");

            update(); // Updates character position
            repaint(); // Draws the screen with new information
        }


    }

    public void update(){

    }
    public void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
    }
    // https://www.youtube.com/watch?v=VpH33Uw-_0E 6:35
}
