/*
 * CS321 - Java Programming
 * Final Project - Team 8 - Ultimate Tic-Tac-Toe
 * 
 * Members:
 * Daniel, Ben, Irene, Zach
 */
package AI;

import Group8.Board;
import Group8.Game;
import Group8.Tile;
import java.util.Random;

/**
 * AI (Computer Player) Class.
 * This class will be created if a game is started with the AI radio button checked. 
 * 
 * 
 * @author Daniel
 */
public class AI {
    Tile tile;
    
    public AI() {
        
    }
    
    /**
     * Called after each turned when currentPlayer is equal to O (AI).
     * Right now it just picks a random number, looks at tile of that number to
     * see if its already been pressed. It will click it if its not pressed,
     * It will create another random number if it has been. 
     * 
     * @param board 
     * @param game A reference to the current game.
     */
    public void pickMove(Board board, Game game) {
        Random rand = new Random();
        int n;
        
        /**
         * If the board the taken by X, by O or tied, the AI can pick any board to play on
         */
        while(("X".equals(board.returnStatus()))||
              ("O".equals(board.returnStatus()))||
              ("T".equals(board.returnStatus())))
            {
                board = game.returnBoard(rand.nextInt(8));
            }
            
        /**
         * Picks a random number, if that tile hasn't been pressed yet, press it
         */
        do {
            n = rand.nextInt(8);
            tile = board.returnTileIndex(n);
        } while ("O".equals(tile.returnStatus()) || "X".equals(tile.returnStatus()));
                
        tile.doClick();
        
    }
}
