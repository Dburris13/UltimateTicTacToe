/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Group8;

/**
 *
 * @author Daniel
 */
public class Main {
    private static void createAndShowGUI() {
        MenuGUI s = new MenuGUI();
        s.setVisible(true);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

        public void run() {
            createAndShowGUI();
        }        
        });
    
    }
}