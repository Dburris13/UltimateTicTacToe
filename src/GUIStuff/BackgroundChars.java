/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIStuff;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author kcnre
 */
public class BackgroundChars {
    int D_HEIGHT = 500; //height of the jFrame
    int randXLoc;
    int y = D_HEIGHT;
    private static final int INCREMENT = 8;
    int randomDelayedStart;
    boolean draw = false;
    boolean down = false;
    Color color;

    public BackgroundChars(int randXLoc, int randomDelayedStart, Color color) {
        this.randXLoc = randXLoc;
        this.randomDelayedStart = randomDelayedStart;
        this.color = color;
    }

    public void drawShape(Graphics g) {
        if (draw) {
            g.setColor(color);
            g.setFont(new Font("TimesRoman", Font.BOLD, 30));
            g.drawString("X", randXLoc, y);
            g.drawString("O", y, randXLoc);
        }
    }

    public void move() {
        if (draw) {
            if (y <= 20) down = true;
            else if (y>=(D_HEIGHT-20)) down = false;

            if (down) {
                y += INCREMENT;
            } else {
                y -= INCREMENT;
            }
        }
    }

    public void decreaseDelay() {
        if (randomDelayedStart <= 0) {
            draw = true;
        } else {
            randomDelayedStart -= 1;
        }
    }

}
    
