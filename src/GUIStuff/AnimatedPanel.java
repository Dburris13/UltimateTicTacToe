/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIStuff;

/**
 *
 * @author kcnre
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;
public class AnimatedPanel extends JPanel{
    
    private static final int D_HEIGHT = 500;
    private static final int D_WIDTH = 770;
    private List<BackgroundChars> backChars;
    private final List<Color> colors;
    private Timer timer = null;
    
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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (BackgroundChars chars : backChars) {
            chars.drawShape(g);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(D_WIDTH, D_HEIGHT);
    }

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

    private List<BackgroundChars> createBackgroundCharsList() {
        List<BackgroundChars> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            int randXLoc = random.nextInt(D_WIDTH);
            int randomDelayedStart = random.nextInt(100);
            int colorIndex = random.nextInt(colors.size());
            Color color = colors.get(colorIndex);
            list.add(new BackgroundChars(randXLoc, randomDelayedStart, color));
        }

        return list;
    }
    
}
