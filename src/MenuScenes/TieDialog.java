/*
 * CS321 - Java Programming
 * Final Project - Team 8 - Ultimate Tic-Tac-Toe
 * 
 * Members:
 * Daniel, Ben, Irene, Zach
 */
package MenuScenes;
import GameFiles.Game;
import javax.swing.JFrame;

/**
 *
 * @author Irene
 */
public class TieDialog extends Dialog {
    public TieDialog(JFrame frame, Game game, String winningPlayer, int winningScore)
    {
        super(frame, game, winningPlayer, winningScore);
        setBackgroundGif();
        setMessageLabel();
        setPlayerName(winningPlayer);
        setPlayerScore(winningPlayer, winningScore);
    }
    public void setBackgroundGif(){
        getBackgroundGif().setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/tictactoe3.gif"))); // NOI18N
        getContentPane().add(getBackgroundGif());
    }
    
    public void setMessageLabel(){
        getMessageLabel().setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getMessageLabel().setText("You Tied!");
    }
    
    public void setPlayerName(String winner){
        getPlayerName().setText("Better Luck Next Time!");
        getPlayerName().setFont(new java.awt.Font("Tahoma", 1, 20));
    }
    
    public void setPlayerScore(String winner, int score){
        getPlayerScore().setText("");
        
    }
}
