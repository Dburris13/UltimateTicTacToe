/* 
 * CS321 - Java Programming
 * Final Project - Team 8 - Ultimate Tic-Tac-Toe
 * 
 * Members:
 * Daniel, Ben, Irene, Zach
 */
package GUIMisc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * A JPanel that contains the animated X's and O's displayed on the GUIMenu.
 * @author Irene
 */
public class AnimatedPanel extends JPanel{
    
    private static final int HEIGHT = 500;
    private static final int WIDTH = 770;
    private List<BackgroundChars> backChars;
    private final List<Color> colors;
    private Timer timer = null;
    
    /**
     * The default constructor for the AnimatedPanel class creates a new JPanel
     * with animated X's and O's. After creating the list of Colors and the list
     * of characters the constructor sets up a timer, that moves moves each character
     * and redraws it.
     */
    public AnimatedPanel() {
        colors = createColorList();
        backChars = createBackgroundCharsList();

        timer = new Timer(150, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (BackgroundChars chars : backChars) {
                    chars.move();
                    chars.decreaseDelay();
                    repaint();
                }
            }
        });

        JPanel panel = new JPanel();
        setLayout(new BorderLayout());
        add(panel, BorderLayout.PAGE_START);
        timer.start();
    }


    /**
     * Overriding the paintComponent method and placing all of our painting code
     * in it. 
     * 
     * @param g Graphics objects 
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (BackgroundChars chars : backChars) {
            chars.drawShape(g);
        }
    }

    
    /**
     * 
     * @return Dimension of frame to draw on
     */
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }
    
    /**
     * This function creates a list of 6 different colors that will be used with
     * the BackgroundChars class.
     * @return list an arrayList of all the colors
    * */
    private List<Color> createColorList() {
        List<Color> list = new ArrayList<>();
        list.add(Color.BLUE);
        list.add(Color.GREEN);
        list.add(Color.ORANGE);
        list.add(Color.MAGENTA);
        list.add(Color.CYAN);
        list.add(Color.PINK);
        return list;
    }

    /**
    * This function creates a list of background characters.
    * It creates 20 XChar's and YChar's each with a randomly selected starting
    * location, color, and start time.
    * @return list 
    * */
    private List<BackgroundChars> createBackgroundCharsList() {
        List<BackgroundChars> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            int randXLoc = random.nextInt(WIDTH);
            int randYLoc = random.nextInt(HEIGHT);
            int randomDelayedStart = random.nextInt(100);
            int colorIndex = random.nextInt(colors.size());
            Color color = colors.get(colorIndex);
            list.add(new XChar(randXLoc, randYLoc, randomDelayedStart, color));
            list.add(new YChar(randXLoc, randYLoc, randomDelayedStart, color));
        }
        return list;
    }    
}
