package MenuScenes;

import GameFiles.Game;
import javax.swing.JFrame;
/**
 * * This is an implementation of the Dialog class to display when a game is tied.
 * It sets the JLabel text to indicate a tie
 * @author Irene
 */
public class WinDialog extends Dialog{
    
    public WinDialog(JFrame frame, Game game, String winningPlayer, int winningScore) {
        super(frame, game, winningPlayer, winningScore);
        setBackgroundGif();
        setMessageLabel();
        setPlayerName(winningPlayer);
        setPlayerScore(winningPlayer, winningScore);
    }
    
    /**
     * Sets the background gif.
     */
    public void setBackgroundGif(){
        getBackgroundGif().setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/fireworks-animated-gif-23.gif"))); // NOI18N
        getContentPane().add(getBackgroundGif());
    }
    
    /**
     * sets the primary message label
     */
    public void setMessageLabel(){
        getMessageLabel().setText("Congratulations,");
    }
    
    /**
     * sets the secondary message label.
     * @param winner winner of the game
     */
    public void setPlayerName(String winner){
        getPlayerName().setText(winner+"!");
    }
    
    /**
     * sets the third message label
     * @param winner winner of the game
     * @param score winner's score
     */
    public void setPlayerScore(String winner, int score){
        getPlayerScore().setText(winner + " score: " + score);
    }
}
