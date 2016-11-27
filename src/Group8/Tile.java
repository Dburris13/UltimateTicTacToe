/* 
 * CS321 - Java Programming
 * Final Project - Team 8 - Ultimate Tic-Tac-Toe
 * 
 * Members:
 * Daniel, Ben, Irene, Zach
 */
package Group8;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class represents a Tile of the Tic-Tac-Toe board.
 * It is the lowest level of our game's hierarchy.
 * 
 * This class extends a JButton and overrides its ActionListener. Any action
 * performed on a Tile advances the state of the game. It does this by calling
 * public Game functions where all "global" variables are kept. Since each level
 * of our game's hierarchy inherits from its parent, the variables used to 
 * track the state of the game are seen by all classes instantiated in our game
 * scene. By declaring public function in Game that can be called by our 
 * ActionListener, we can very easily control the flow of the game. 
 * 
 * @author Daniel
 * @author Ben
 */
public class Tile extends JButton implements ActionListener {
    
    private final Game game;
    private final Board brd;
    private int tileIndex =0, brdIndex = 0;
    
    /**
     * Default Constructor.
     * 
     * @param game inherits Game methods
     * @param brd inherits Board methods
     * @param turn status to be set (X or O)
     * @param color color to be set to (user settings)
     */
    public Tile(Game game, Board brd, char turn, Color color) {
        this.game = game;
        this.brd = brd;
        initComponents(color);
    }
    
    /**
     * Object initialization. 
     * 
     * Draws the object and overrides its ActionListener.
     * 
     * @param color of Tile
     */
    private void initComponents(Color color) {
        this.addActionListener(this);
        this.setBackground(color);
        this.setForeground(Color.PINK);
    }
    
    /**
     * Status Return.
     * 
     * This method is called when we're checking for the state of the game.
     * Each Tile has the responsibility to return it's own status when his board
     * asks for it. His status is given to him from the Game. 
     * 
     * @return String representing his status
     */
    public String returnStatus() {
        return getText();
    }
    
    /**
     * Action Performed.
     * 
     * This method is called when the Tile is pressed.
     * It will set its status and index based on what is based to him from Board
     * and from Game.
     * 
     * It then advances the state of the game using it's inherited Game methods.
     * 
     * @param ae 
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        /**
         * Grabbing the indexes of the Tile
         */
        for(int i =0; i<9; i++) {
            for(int k =0; k<9; k++) {
                if(ae.getSource() == game.returnBoardTile(i, k)) {
                    tileIndex = k;
                    brdIndex = i;
                }
            }
        }
        
        /**
         * Visually displaying the status of Tile
         */
        this.setFont(new Font("Arial", Font.PLAIN, 80));
        this.setText((game.currentPlayer.returnStatus() ? "X" : "O"));
        
        /**
         * Advancing the state of the game using inherited methods
         */
        game.endTurn(tileIndex);
        
        try {
            game.checkWinner();
        } catch (IOException ex) {
            Logger.getLogger(Tile.class.getName()).log(Level.SEVERE, null, ex);
        }
        game.manageBoard(tileIndex, brdIndex, tileIndex);
    }
}
