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
 *
 * @author Daniel, Irene, Ben, Zach
 */
public class Main {
    private static void createAndShowGUI() {
        MenuGUI s = new MenuGUI();
        s.setVisible(true);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        javax.swing.SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    
    }
}