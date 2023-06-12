package entity;

import java.awt.*;

public class HealthBar {
    private int x;
    private int y;
    private int width;
    private int height;
    private int maxHealth;
    private int currentHealth;

    public HealthBar(int x, int y, int width, int height, int maxHealth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }
    public int getCurrentHealth(){return currentHealth;}

    public int  changeCurrentHealth(int healthChange, String y){

        if (y.equals("+")){

            if (currentHealth+healthChange > maxHealth){

                return currentHealth = maxHealth;}
            else { currentHealth += healthChange;}
        }
        else if (y.equals("-")){

            if (currentHealth-healthChange <= 0){
                return currentHealth = 0;}
            else {currentHealth -= healthChange;}

        }
        return currentHealth;
    }

    public void draw(Graphics2D g2) {
        // Draw the outline of the health bar
        g2.setColor(Color.BLACK);
        g2.drawRect(x, y, width, height);

        double healthPercentage = (double) currentHealth / maxHealth;

        // Calculate the width of the health bar based on the current health percentage
        int currentWidth = (int) (width * healthPercentage);

        // Draw the filled portion of the health bar
        g2.setColor(Color.black);
        g2.fillRect(x-5,y-5,currentWidth+10,height+10);
        g2.setColor(Color.red);
        g2.fillRect(x, y, currentWidth, height);

        // Draw lines to indicate health levels
        g2.setColor(Color.WHITE);
        int numLines = 5; // Number of lines to display
        int lineSpacing = width / numLines; // Spacing between each line
        int lineY = y + height; // Vertical position of the lines
        for (int i = 1; i < numLines; i++) {
            int lineX = x + (i * lineSpacing); // Horizontal position of each line
            g2.drawLine(lineX, y, lineX, lineY);
        }
    }
}
