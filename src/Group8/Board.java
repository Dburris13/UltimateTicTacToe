package Group8;

import java.awt.*;
import java.applet.Applet;

/**
 * This is the Board class which encapsulates 9 Tile classes.
 * It is the 2nd lowest class in our game's hierarchy. 
 * 
 * It is responsible for return its own status to BigBoard and
 * keeping track of the status of it's 9 Tiles. 
 * 
 * @author Daniel
 * @author Ben
 */
public class Board extends Applet {
    
    private char turn;
    private Color brdColor;
    private Tile[] btnArray = new Tile[9];
    private String brdStatus = ""; 
    
    public Board (Game game, Color color) {
        brdColor = color;
        
        GridLayout gl = new GridLayout (3,3,1,1);
        this.setLayout(gl);
                
        for (int i = 0; i < 9; i++) {
            btnArray[i] = new Tile(game, this, turn, brdColor);
            this.add(btnArray[i]);
        }
    }    
    
    /**
     * This method checks to see if anyone has won the board yet.
     */
    public void checkWinner() {
        /**
         * Checking if board is full
         */
        if  (btnArray[0].returnStatus() != "" && btnArray[1].returnStatus() != "" && btnArray[2].returnStatus() != ""
            && btnArray[3].returnStatus() != "" && btnArray[4].returnStatus() != "" && btnArray[5].returnStatus() != ""
            && btnArray[6].returnStatus() != "" && btnArray[7].returnStatus() != "" && btnArray[8].returnStatus() != "")
        {
            brdStatus = "T";
        }     
        
        /**
         * Checking if X won
         */
        if (btnArray[0].returnStatus() == "X" && btnArray[1].returnStatus() == "X" && btnArray[2].returnStatus() == "X"
            ||btnArray[3].returnStatus() == "X" && btnArray[4].returnStatus() == "X" && btnArray[5].returnStatus() == "X"
            ||btnArray[6].returnStatus() == "X" && btnArray[7].returnStatus() == "X" && btnArray[8].returnStatus() == "X"
            ||btnArray[0].returnStatus() == "X" && btnArray[3].returnStatus() == "X" && btnArray[6].returnStatus() == "X"
            ||btnArray[1].returnStatus() == "X" && btnArray[4].returnStatus() == "X" && btnArray[7].returnStatus() == "X"
            ||btnArray[2].returnStatus() == "X" && btnArray[5].returnStatus() == "X" && btnArray[8].returnStatus() == "X"
            ||btnArray[0].returnStatus() == "X" && btnArray[4].returnStatus() == "X" && btnArray[8].returnStatus() == "X"
            ||btnArray[2].returnStatus() == "X" && btnArray[4].returnStatus() == "X" && btnArray[6].returnStatus() == "X") 
        {               
            brdStatus = "X";
        }
        
        /**
         * Checking if O won
         */
        if (btnArray[0].returnStatus() == "O" && btnArray[1].returnStatus() == "O" && btnArray[2].returnStatus() == "O"
            ||btnArray[3].returnStatus() == "O" && btnArray[4].returnStatus() == "O" && btnArray[5].returnStatus() == "O"
            ||btnArray[6].returnStatus() == "O" && btnArray[7].returnStatus() == "O" && btnArray[8].returnStatus() == "O"
            ||btnArray[0].returnStatus() == "O" && btnArray[3].returnStatus() == "O" && btnArray[6].returnStatus() == "O"
            ||btnArray[1].returnStatus() == "O" && btnArray[4].returnStatus() == "O" && btnArray[7].returnStatus() == "O"
            ||btnArray[2].returnStatus() == "O" && btnArray[5].returnStatus() == "O" && btnArray[8].returnStatus() == "O"
            ||btnArray[0].returnStatus() == "O" && btnArray[4].returnStatus() == "O" && btnArray[8].returnStatus() == "O"
            ||btnArray[2].returnStatus() == "O" && btnArray[4].returnStatus() == "O" && btnArray[6].returnStatus() == "O") 
        {            
            brdStatus = "O";
        }   
    }    
    
    /**
     * This method returns the status of the board.
     * @return 
     */
    public String returnStatus() 
    {
        return brdStatus;
    }
    
    /**
     * This method returns the color of the board
     * @return 
     */
    public Color returnColor() 
    {
        return brdColor;
    }
    
    /**
     * This method returns the Tile at a specific index
     * @param btnArrayIndex
     * @return 
     */
    public Tile returnTileIndex(int btnArrayIndex)
    {
        return btnArray[btnArrayIndex];
    }
   
}
