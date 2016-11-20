/* 
 * CS321 - Java Programming
 * Final Project - Team 8 - Ultimate Tic-Tac-Toe
 * 
 * Members:
 * Daniel, Ben, Irene, Zach
 */
package Group8;
import java.awt.*;
import java.applet.Applet;

/**
 * This class represents a Board of 9 Tiles.
 * This class is made up of 9 Tile classes.
 * It is responsible for return its own status to BigBoard and
 * keeping track of the status of it's 9 Tiles. 
 * 
 * It is the 2nd lowest class in our game's hierarchy. 
 * 
 * This class extends Applet and implements a 3x3 GridLayout so that it can
 * easily build a Tic-Tac-Toe board with our Tile class. This creates very simple
 * graphics manipulation because Tile classes draw themselves, so we need only
 * create 9 of them and place them into the GridLayout. This classes private 
 * methods will manage its nine tiles and return information such as color of 
 * the board and status of the board (has it been won yet).
 * 
 * @author Daniel
 * @author Ben
 */
public class Board extends Applet {
    
    private char turn;
    private Color brdColor;
    /**
     * We know there will only be 9 tiles to a board
     */
    private Tile[] btnArray = new Tile[9];
    private String brdStatus = ""; 
    
    /**
     * Default Constructor.
     * 
     * @param game inherits Game methods
     * @param color color to be set to (user settings)
     */
    public Board (Game game, Color color) {
        /**
         * All nine buttons will be this color
         */
        brdColor = color;
        
        /**
         * Creating our Tic-Tac-Toe board layout
         */
        GridLayout gl = new GridLayout (3,3,1,1);
        this.setLayout(gl);
                
        /**
         * Creating our 9 Tiles
         */
        for (int i = 0; i < 9; i++) {
            btnArray[i] = new Tile(game, this, turn, brdColor);
            this.add(btnArray[i]);
        }
    }    
    
    /**
     * Status Check.
     * 
     * This method checks each Tile to see if their is a winning combination and
     * if its status needs to be updated. It checks to see if the board is full
     * and initially states that the board has been tied, but later runs checks
     * that will override this status if appropriate.
     */
    public void checkWinner() {
        /**
         * Checking if board is full, but not won (Tie)
         */
        if  (!"".equals(btnArray[0].returnStatus()) && !"".equals(btnArray[1].returnStatus()) && !"".equals(btnArray[2].returnStatus())
            && !"".equals(btnArray[3].returnStatus()) && !"".equals(btnArray[4].returnStatus()) && !"".equals(btnArray[5].returnStatus())
            && !"".equals(btnArray[6].returnStatus()) && !"".equals(btnArray[7].returnStatus()) && !"".equals(btnArray[8].returnStatus()))
        {
            brdStatus = "T";
        }     
        
        /**
         * Checking if X won
         */
        if ("X".equals(btnArray[0].returnStatus()) && "X".equals(btnArray[1].returnStatus()) && "X".equals(btnArray[2].returnStatus())
            ||"X".equals(btnArray[3].returnStatus()) && "X".equals(btnArray[4].returnStatus()) && "X".equals(btnArray[5].returnStatus())
            ||"X".equals(btnArray[6].returnStatus()) && "X".equals(btnArray[7].returnStatus()) && "X".equals(btnArray[8].returnStatus())
            ||"X".equals(btnArray[0].returnStatus()) && "X".equals(btnArray[3].returnStatus()) && "X".equals(btnArray[6].returnStatus())
            ||"X".equals(btnArray[1].returnStatus()) && "X".equals(btnArray[4].returnStatus()) && "X".equals(btnArray[7].returnStatus())
            ||"X".equals(btnArray[2].returnStatus()) && "X".equals(btnArray[5].returnStatus()) && "X".equals(btnArray[8].returnStatus())
            ||"X".equals(btnArray[0].returnStatus()) && "X".equals(btnArray[4].returnStatus()) && "X".equals(btnArray[8].returnStatus())
            ||"X".equals(btnArray[2].returnStatus()) && "X".equals(btnArray[4].returnStatus()) && "X".equals(btnArray[6].returnStatus())) 
        {               
            brdStatus = "X";
        }
        
        /**
         * Checking if O won
         */
        if ("O".equals(btnArray[0].returnStatus()) && "O".equals(btnArray[1].returnStatus()) && "O".equals(btnArray[2].returnStatus())
            ||"O".equals(btnArray[3].returnStatus()) && "O".equals(btnArray[4].returnStatus()) && "O".equals(btnArray[5].returnStatus())
            ||"O".equals(btnArray[6].returnStatus()) && "O".equals(btnArray[7].returnStatus()) && "O".equals(btnArray[8].returnStatus())
            ||"O".equals(btnArray[0].returnStatus()) && "O".equals(btnArray[3].returnStatus()) && "O".equals(btnArray[6].returnStatus())
            ||"O".equals(btnArray[1].returnStatus()) && "O".equals(btnArray[4].returnStatus()) && "O".equals(btnArray[7].returnStatus())
            ||"O".equals(btnArray[2].returnStatus()) && "O".equals(btnArray[5].returnStatus()) && "O".equals(btnArray[8].returnStatus())
            ||"O".equals(btnArray[0].returnStatus()) && "O".equals(btnArray[4].returnStatus()) && "O".equals(btnArray[8].returnStatus())
            ||"O".equals(btnArray[2].returnStatus()) && "O".equals(btnArray[4].returnStatus()) && "O".equals(btnArray[6].returnStatus())) 
        {            
            brdStatus = "O";
        }   
    }    
    
    /**
     * Status Return.
     * 
     * This method returns the status of the board. (X, O, or T)
     * @return String representing X, O, or T
     */
    public String returnStatus() 
    {
        return brdStatus;
    }
    
    /**
     * Color Return.
     * 
     * This method returns the color of the board.
     * @return Color
     */
    public Color returnColor() 
    {
        return brdColor;
    }
    
    /**
     * Tile Index Return.
     * 
     * This method returns the Tile at a specific index.
     * @param btnArrayIndex
     * @return 
     */
    public Tile returnTileIndex(int btnArrayIndex)
    {
        return btnArray[btnArrayIndex];
    }
   
}
