package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controls implements KeyListener {
    GamePanel gp;

    public boolean upPressed, downPressed, leftPressed, rightPressed, attackPressed,heal;

    public Controls(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode(); // returns the number of the key pressed ex A = 65
        // Title State Controls
        if (gp.gameState == gp.TITLE_STATE) {
            if (code == KeyEvent.VK_W) {
                if (gp.ui.cmdNum > 0) {
                    gp.ui.cmdNum--;
                }
            }
            if (code == KeyEvent.VK_S) {
                if (gp.ui.cmdNum < 2) {
                    gp.ui.cmdNum++;
                }
            }
            if (code == KeyEvent.VK_ENTER){
                if (gp.ui.cmdNum == 0){
                    gp.aSetter.setDragon();
                    gp.player.setDefaultValues();

                    gp.gameState = gp.PLAY_STATE;
                }
                if (gp.ui.cmdNum == 1){
                    gp.loadData();
                    gp.gameState = gp.PLAY_STATE;

                }
                if (gp.ui.cmdNum == 2){
                    System.exit(0);
                }

            }
        }

        // Play State Controls
        else if (gp.gameState == 1) {
            if (code == KeyEvent.VK_W) {
                upPressed = true;
            }
            if (code == KeyEvent.VK_A) {
                leftPressed = true;
            }
            if (code == KeyEvent.VK_S) {
                downPressed = true;
            }
            if (code == KeyEvent.VK_D) {
                rightPressed = true;
            }
            if (code == KeyEvent.VK_J) {
                attackPressed = true;
            }
            if (code == KeyEvent.VK_K) {
                heal = true;
            }
        }
        // Pause State Controls
        if (code == KeyEvent.VK_ESCAPE) {
            if (gp.gameState == gp.PLAY_STATE) {
                gp.gameState = gp.PAUSE_STATE;
            }
        }
        else if (gp.gameState == gp.PAUSE_STATE){
            if (code == KeyEvent.VK_W) {
                if (gp.ui.cmdNum > 0) {
                    gp.ui.cmdNum--;
                }
            }
            if (code == KeyEvent.VK_S) {
                if (gp.ui.cmdNum < 1) {
                    gp.ui.cmdNum++;
                }
            }
            if (code == KeyEvent.VK_ENTER){
                if (gp.ui.cmdNum == 0){
                    gp.saveData();
                    gp.gameState = gp.TITLE_STATE;
                }
                if (gp.ui.cmdNum == 1){
                    gp.gameState = gp.PLAY_STATE;

                }

            }
        }
        // Dead State Controls
        else if (gp.gameState == gp.DEAD_STATE){
            if (code == KeyEvent.VK_ENTER){
                gp.gameState = gp.TITLE_STATE;
            }

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();




        if (code == KeyEvent.VK_W) {
            upPressed = false;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = false;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = false;
        }
        if (code == KeyEvent.VK_J) {
            attackPressed = false;
        }
        if (code == KeyEvent.VK_K) {
            heal = false;
        }
    }
}

