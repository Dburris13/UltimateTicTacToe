/* 
 * CS321 - Java Programming
 * Final Project - Team 8 - Ultimate Tic-Tac-Toe
 * 
 * Members:
 * Daniel, Ben, Irene, Zach
 */
package GUIMisc;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * A class that creates an animated X character.
 * @author Irene
 */
public class XChar extends BackgroundChars{
    private static final int INCREMENT = 8;

    /**
     * Constructs the XChar object using it's superclass constructor.
     * @param randXLoc x position of the character
     * @param randYLoc y position of the character
     * @param randomDelayedStart an integer used to delay the drawing of the 
     * character
     * @param color color of the character
     */
    public XChar(int randXLoc, int randYLoc, int randomDelayedStart, Color color) {
        super(randXLoc, randYLoc, randomDelayedStart, color);
    }

    /**
     * Implementation of BackgroundChars drawShape() function that draws "X".
     * The string is given a color, and a style.
     * @param g 
     */
    @Override
    void drawShape(Graphics g) {
        if (draw) {
            g.setColor(color);
            g.setFont(new Font("TimesRoman", Font.BOLD, 30));
            g.drawString("X", randXLoc, randYLoc);     //vertical
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Implementation of BackgroundChars move() function that moves the character 
     * vertically.
     */
    @Override
    void move() {
        if (draw) {
            if (randYLoc <= 20) down = true;
            else if (randYLoc>=(D_HEIGHT-20)) down = false;

            if (down) {
                randYLoc += INCREMENT;
            } else {
                randYLoc -= INCREMENT;
            }
        }
    }
    
}