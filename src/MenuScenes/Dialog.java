/*
 * CS321 - Java Programming
 * Final Project - Team 8 - Ultimate Tic-Tac-Toe
 * 
 * Members:
 * Daniel, Ben, Irene, Zach
 */
package MenuScenes;
import GameFiles.Game;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * This is the dialog box that pops up after the game as ended.
 * It will display different text based on if the game resulted in a tie
 * or a win for either player or even the AI. 
 * 
 * @author Irene
 */
public abstract class Dialog extends JDialog{
    private final javax.swing.JLabel backgroundGif;
    private final javax.swing.JLabel messageLabel;
    private final javax.swing.JLabel playerName;
    private final javax.swing.JLabel playerScore1;
    private final javax.swing.JButton menuReturnBtn;
    
    /**
     * Drawing the Dialog box.
     * 
     * @param frame parent frame that we're in
     * @param game Game object that 
     * @param Player winning player -- may not be used in all implementations
     * @param Score winning player score -- may not be used in all implementations
     */
    public Dialog(JFrame frame, Game game, String Player, int Score)
    {
        super(frame, true);
        backgroundGif = new javax.swing.JLabel();
        messageLabel = new javax.swing.JLabel();
        playerName = new javax.swing.JLabel();
        playerScore1 = new javax.swing.JLabel();
        menuReturnBtn = new javax.swing.JButton();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(525, 525));
        getContentPane().setLayout(null);
        
        messageLabel.setFont(new java.awt.Font("Tahoma",1,36));
        messageLabel.setForeground(new java.awt.Color(255, 255, 0));
        getContentPane().add(messageLabel);
        messageLabel.setBounds(100, 120, 310, 44);
        
        playerName.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        playerName.setForeground(new java.awt.Color(255, 255, 0));
        playerName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(playerName);
        playerName.setBounds(100, 200, 330, 110);
        
        playerScore1.setFont(new java.awt.Font("Tahoma", 1, 24));
        playerScore1.setForeground(new java.awt.Color(255, 255, 0));
        //playerScore1.setText(Player + " score: " + Score);
        getContentPane().add(playerScore1);
        playerScore1.setBounds(40,320,260,30);
        
        menuReturnBtn.setText("Return to Menu");
        menuReturnBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuReturnBtnActionPerformed(evt, game);
            }
        });
        getContentPane().add(menuReturnBtn);
        menuReturnBtn.setBounds(323, 430, 160, 29);
        
        /*backgroundGif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/fireworks-animated-gif-23.gif"))); // NOI18N
        getContentPane().add(backgroundGif);*/
        backgroundGif.setBounds(0, 0, 500, 474);
        
        pack();
        setLocationRelativeTo(frame);
    }
    
    /**
     * Returns to menu when button is clicked
     * @param evt action object
     * @param game reference to the game frame
     */
    private void menuReturnBtnActionPerformed(java.awt.event.ActionEvent evt, Game game) {                                              
        game.goToMenu();
    }
    
    /**
     * returns backgoundGif JLabel.
     * @return backgroundGid JLabel
     */
    public javax.swing.JLabel getBackgroundGif()
    {
        return backgroundGif;
    }
    
    /**
     * sets the backgroundGif JLabel.
     */
    abstract void setBackgroundGif();
    
    /**
     * returns the primary message label.
     * @return primary message label
     */
    public javax.swing.JLabel getMessageLabel()
    {
        return messageLabel;
    }
    
    /**
     * sets the primary message label.
     */
    abstract void setMessageLabel();
    
    /**
     * returns the second message label
     * @return  secondary message label
     */
    public javax.swing.JLabel getPlayerName()
    {
        return playerName;
    }
    
    /**
     * sets the second message label.
     * @param name winning player -- not used in all implementations.
     */
    abstract void setPlayerName(String name);
    
    /**
     * returns third message label.
     * @return third message label
     */
    public javax.swing.JLabel getPlayerScore()
    {
        return playerScore1;
    }
    
    /**
     * sets third message label
     * @param name winning player -- not used in all implementations.
     * @param score winning score -- not used in all implementations
     */
    abstract void setPlayerScore(String name, int score);
    
}

