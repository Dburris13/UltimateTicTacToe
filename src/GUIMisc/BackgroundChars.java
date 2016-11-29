/* 
 * CS321 - Java Programming
 * Final Project - Team 8 - Ultimate Tic-Tac-Toe
 * 
 * Members:
 * Daniel, Ben, Irene, Zach
 */
package GUIMisc;

import java.awt.Color;
import java.awt.Graphics;

/**
 * An abstract class defining the characters that will be displayed in the 
 * AnimatedPanel class
 * @author Irene
 */
public abstract class BackgroundChars {
    int D_HEIGHT = 500; //height of the jFrame
    int D_WIDTH = 750; //width of the jframe
    int randXLoc;
    int randYLoc;
    int randomDelayedStart;
    boolean draw = false;
    boolean down = false;
    Color color;

    /**
     * Constructor that initializes the characters settings. Sets the starting 
     * x and y position of the character. Then it sets a counter integer to
     * delay the drawing of the character, and the color.
     * @param randXLoc the random starting x location of the character
     * @param randYLoc the random starting y location of the character
     * @param randomDelayedStart an integer used to delay the drawing of the 
     * character
     * @param color color of the character
     */
    public BackgroundChars(int randXLoc,int randYLoc, int randomDelayedStart, Color color) {
        this.randXLoc = randXLoc;
        this.randYLoc = randYLoc;
        this.randomDelayedStart = randomDelayedStart;
        this.color = color;
    }

    /**
     * A function that delays the drawing of a character. When the int 
     * randomDelayedStart reaches 0, the boolean value draw is changed to true 
     * so that the new character will be drawn.
     */
    public void decreaseDelay() {
        if (randomDelayedStart <= 0) {
            draw = true;
        } else {
            randomDelayedStart -= 1;
        }
    }
    /**
     * An abstract method of what will be drawn.
     * @param g 
     */
    abstract void drawShape(Graphics g); 
    
    /**
     * An abstract method of character movement. 
     */
    abstract void move(); 

}