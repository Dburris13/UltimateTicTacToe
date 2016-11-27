/* 
 * CS321 - Java Programming
 * Final Project - Team 8 - Ultimate Tic-Tac-Toe
 * 
 * Members:
 * Daniel, Ben, Irene, Zach
 */
package Group8;

import MenuScenes.MenuGUI;

/**
 * Main. 
 * The main simply takes us into the Main Menu of our application.
 * 
 * @author Daniel
 * @author Ben
 * @author Irene
 * @author Zach
 */
public class Main {
    /**
     * Create and show a new MenuGUI object.
     */
    private static void createAndShowGUI() {
        MenuGUI s = new MenuGUI();
        s.setVisible(true);
    }
    
    public static void main(String[] args) {        
        javax.swing.SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    
    }
}