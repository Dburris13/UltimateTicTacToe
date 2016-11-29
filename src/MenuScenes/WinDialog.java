package MenuScenes;

import GameFiles.Game;
import javax.swing.JFrame;


public class WinDialog extends Dialog{
    
    public WinDialog(JFrame frame, Game game, String winningPlayer, int winningScore) {
        super(frame, game, winningPlayer, winningScore);
        setBackgroundGif();
        setMessageLabel();
        setPlayerName(winningPlayer);
        setPlayerScore(winningPlayer, winningScore);
    }
    public void setBackgroundGif(){
        getBackgroundGif().setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/fireworks-animated-gif-23.gif"))); // NOI18N
        getContentPane().add(getBackgroundGif());
    }
    
    public void setMessageLabel(){
        getMessageLabel().setText("Congratulations,");
    }
    
    public void setPlayerName(String winner){
        getPlayerName().setText(winner+"!");
    }
    
    public void setPlayerScore(String winner, int score){
        getPlayerScore().setText(winner + " score: " + score);
    }
}
