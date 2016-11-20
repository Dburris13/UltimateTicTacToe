/* 
 * CS321 - Java Programming
 * Final Project - Team 8 - Ultimate Tic-Tac-Toe
 * 
 * Members:
 * Daniel, Ben, Irene, Zach
 */
package GUIStuff;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * A class that creates an animated Y character.
 * @author Irene
 */
public class YChar extends BackgroundChars{
    private static final int INCREMENT = 8;

    /**
     * Constructs the YChar object using it's superclass constructor.
     * @param randXLoc x position of the character
     * @param randYLoc y position of the character
     * @param randomDelayedStart an integer used to delay the drawing of the 
     * character
     * @param color color of the character
     */
    public YChar(int randXLoc, int randYLoc, int randomDelayedStart, Color color) {
        super(randXLoc, randYLoc, randomDelayedStart, color);
    }
    
    /**
     * Implementation of BackgroundChars drawShape() function that draws "O".
     * The string is given a color, and a style.
     * @param g 
     */
    @Override
    void drawShape(Graphics g) {
        if (draw) {
            g.setColor(color);
            g.setFont(new Font("TimesRoman", Font.BOLD, 30));
            g.drawString("O", randXLoc, randYLoc);     //horizontal
        }
    }
    
    /**
     * Implementation of BackgroundChars move() function that moves the character 
     * horizontally.
     */
    public void move(){
        if (draw) {
            if (randXLoc <= 20) down = true;
            else if (randXLoc>=(D_WIDTH-20)) down = false;

            if (down) {
                randXLoc += INCREMENT;
            } else {
                randXLoc -= INCREMENT;
            }
        }
        
    }
}