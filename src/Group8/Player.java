/* 
 * CS321 - Java Programming
 * Final Project - Team 8 - Ultimate Tic-Tac-Toe
 * 
 * Members:
 * Daniel, Ben, Irene, Zach
 */
package Group8;

/**
 * Player Class.
 * This class is in charge of tracking whose turn it is while playing the game.
 * He is called by the Game scene often.
 * 
 * @author Daniel
 */
public class Player {
    /**
     * true = player 1, false = player 2
     */
    public boolean currentPlayer;
    
    /**
     * Default Constructor.
     * Game determines whose turn we start on.
     * 
     * @param whoseTurn 
     */
    public Player(boolean whoseTurn) {
        currentPlayer = whoseTurn;    
    }
    
    /**
     * Status Return.
     * Returns whose turn it currently is.
     * 
     * @return 
     */
    public boolean returnStatus() {
        return currentPlayer;
    }
    
    /**
     * Toggle Turn.
     * Simply flips X to O and O to X when its called.
     * 
     * @return boolean value, false = O, true = X
     */
    public boolean switchPlayer() {    
        if (currentPlayer == true) {
            currentPlayer = false;
        } else {
            currentPlayer = true;
        }
        
        return currentPlayer;
    }
    
    
}
