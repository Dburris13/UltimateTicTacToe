package Group8;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;

/**
 * This is the tile class. 
 * It is the lowest level of our game's hierarchy.
 * 
 * It is a sub-class of a JButton and overrides its ActionListener
 * Any action performed on a tile advanced the state of the game,
 * by calling function directly from Game. This was the whole logic
 * behind our hierarchy system.
 * 
 * @author Daniel
 */
public class Tile extends JButton implements ActionListener {
    
    private Game game;
    private Board brd;
    private int tileIndex =0, brdIndex = 0;
   
    
    /**
     * Default Constructor .
     * 
     * This constructor is given the top-level function needed to progress the game
     * and the board that he is apart of. 
     * 
     * @param game game methods
     * @param brd board index
     * @param turn status to be set
     * @param color color to be set to
     */
    public Tile(Game game, Board brd, char turn, Color color) {
        this.addActionListener(this);
        this.setBackground(color);
        this.setForeground(Color.PINK);
        this.game = game;
        this.brd = brd;
    }
    
    /**
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
     * This method is called when the Tile is pressed.
     * This method has only to worry about itself. It figures out what it's
     * index in the game it is and determines what it's status will be. 
     * 
     * It then advances the state of the game using top-level methods passed to it.
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
         * Visually displaying the status of Tile.
         */
        this.setFont(new Font("Arial", Font.PLAIN, 80));
        this.setText((game.currentPlayer.returnStatus() ? "X" : "O"));
        
        /**
         * Advancing the state of the game usually top-level methods. 
         */
        game.endTurn();
        game.checkWinner();
        game.manageBoard(tileIndex, brdIndex);
    }
}
