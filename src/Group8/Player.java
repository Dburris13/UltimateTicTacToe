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
public class Player {
    public boolean currentPlayer;
    
    public Player(boolean whoseTurn) {
        currentPlayer = whoseTurn;    
    }
    
    public boolean returnStatus() {
        return currentPlayer;
    }
    
    public boolean switchPlayer() {    
        if (currentPlayer == true) {
            currentPlayer = false;
        } else {
            currentPlayer = true;
        }
        
        return currentPlayer;
    }
    
    
}
