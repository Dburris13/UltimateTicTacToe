/* 
 * CS321 - Java Programming
 * Final Project - Team 8 - Ultimate Tic-Tac-Toe
 * 
 * Members:
 * Daniel, Ben, Irene, Zach
 */
package GameFiles;
import AI.AI;
import PlayerInfo.FileProfile;
import PlayerInfo.Player;
import PlayerInfo.UserInfo;
import MenuScenes.MenuGUI;
import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 * This class represents our game scene.
 * This class features a small menu bar, text to display whose turn it is, and 
 * our BigBoard class.
 * 
 * It encapsulates the class BigBoard, Board, and Tile. It is organized
 * with a border layout, display the BigBoard into the CENTER position
 * and the "helper" test into the NORTH position.
 * 
 * Upon entering the game scene it will update the user's profile if one
 * has been selected. It uses the FileHandler class to update the user's
 * "GamesPlayed" statistic. It will update the user's "GamesWon" statistic
 * on exit if the player is a winner. 
 * 
 * This scene is different from the rest of the GUIs that we have because
 * it is not constructed with the NetBeans drop and drop interface. We didn't
 * use the drag and drop interface here because we are manually drawing our
 * BigBoard, Board, and Tile classes and it was easier to code our own JFrame
 * with a borderLayout instead of user the NetBeans GUI to do it. However, we
 * did pull code from the drop and drop generated code to get a head start.
 * 
 * @author Daniel
 * @author Ben
 */
public class Game extends JFrame{
    /**
     * Player represents the active user in the game, whoever's turn it is
     */
    public Player currentPlayer = new Player(true);
    private BigBoard bboard;
    private JLabel lbl1 = new JLabel();
    private int countX=0;
    private int countO=0;
    UserInfo player1;
    UserInfo player2;    
    private AI enemy = new AI();
    
    private FileProfile fh;
    private FileProfile fh2;
    private String[] lines;
    
    /**
     * Default constructor
     * 
     * @param profile1 player1
     * @param profile2 player2
     */
    public Game(UserInfo profile1, UserInfo profile2) {
        this.player1 = profile1;
        if (player1.getGamemode() == 1) {
            this.player2 = new UserInfo();
            player2.setUsername("Computer AI");
        } else {
            this.player2 = profile2;
        }
        initGame();   
        fh = new FileProfile(player1.getUsername());
        fh2 = new FileProfile(player2.getUsername());
        
        try {     
            updateGamesPlayed();
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Class Initialization.
     * 
     * Creates the JFrame and Menu layout / design
     * A lot of this code was borrowed from the drag and drop GUI features of NetBeans
     */
    private void initGame() {
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(player1.getResolution());
        BorderLayout bL = new BorderLayout(5,5);
        this.setLayout(bL);
         
       
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("File");

        jMenuItem2.setText("Return to Menu");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });        
        jMenu1.add(jMenuItem2);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1); 
        
        /**
         * Building our BigBoard class on the and adding it to the JFrame.
         */
        bboard = new BigBoard(this);
        
        lbl1.setText("X: " + player1.getUsername() + "     Player's Turn     " + player2.getUsername() + " :O");
        lbl1.setText(String.format("<html> <font color = 'red'> X &nbsp &nbsp &nbsp %s <font color = 'black'> &nbsp &nbsp &nbsp &nbsp Player's Turn &nbsp &nbsp &nbsp &nbsp <font color = 'black'> %s &nbsp &nbsp &nbsp O </html>", player1.getUsername(), player2.getUsername()));
        lbl1.setHorizontalAlignment(SwingConstants.CENTER);
        lbl1.setFont(new Font("Arial", Font.PLAIN, 20));
        
        
        this.add(lbl1, BorderLayout.NORTH);
        this.add(bboard, BorderLayout.CENTER);
        this.setLocationRelativeTo(null);
    }
    
    /**
     * Update Games Won.
     * This method increments the GamesWon attribute of the current user's profile.
     * 
     * This method creates a new instance of the FileHandler class and passes in the
     * usernames of 1 or both players depending on the game mode. The FileHandler class
     * returns all the players current statistics and uses a simple line replace
     * function we updated the gamesPlayed statistic.
     * 
     * This method is private because it only needs to be called at the end of a game.
     * 
     * @throws IOException if File cannot be accessed
     */
    public void updateGamesWon() throws IOException {
        /*
         * Writing to player1's user profile
         * Incrementing games won by 1
         * Only executed is a player's profile is loaded and not the default
         * Guest profile and player 1 won
         */        
        if (currentPlayer.returnStatus() == false) {
            if (player1.getUsername().equals("Guest")) {
            } else {
                lines = fh.readFile();

                /*
                * Parsing through the file and making sure were reading / updating
                * the correct line in the User Profiles files
                */
                String input = "";
                for (String line : lines) {
                    String[] parts = line.split(" ");
                    input += line + '\n';
                    if (null != parts) switch (parts[0]) {
                        case "GamesWon:":       
                            int gamesWon = Integer.parseInt(parts[1]);
                            int newGamesWon = gamesWon+1;
                            input = input.replace("GamesWon: " + gamesWon, "GamesWon: " + newGamesWon);
                            break;
                        default:
                            break;
                    }
                }
                fh.writeFile(input);
            }
        } else {
            /*
             * Writing to player2's user profile
             * Incrementing games played by 1
             * Only executed is a player's profile is loaded and not the default
             * Guest profile and player 2 won
             */
            if (player2.getUsername().equals("Guest2")) {
            } else {
                lines = fh2.readFile();

                /*
                * Parsing through the file and making sure were reading / updating
                * the correct line in the User Profiles files
                */
                String input = "";
                for (String line : lines) {
                    String[] parts = line.split(" ");
                    input += line + '\n';
                    if (null != parts) switch (parts[0]) {
                        case "GamesWon:":       
                            int gamesWon = Integer.parseInt(parts[1]);
                            int newGamesWon = gamesWon+1;
                            input = input.replace("GamesWon: " + gamesWon, "GamesWon: " + newGamesWon);
                            break;
                        default:
                            break;
                    }
                }
                fh2.writeFile(input);
            }
        }
    }
    
    /**
     * Update Games Played.
     * This method increments the GamePlayed attribute of the current user's profile.
     * 
     * This method creates a new instance of the FileHandler class and passes in the
     * usernames of 1 or both players depending on the game mode. The FileHandler class
     * returns all the players current statistics and uses a simple line replace
     * function we updated the gamesPlayed statistic.
     * 
     * This method is private because it only needs to be called at the start of a game.
     * 
     * @throws IOException if File cannot be accessed
     */
    private void updateGamesPlayed() throws IOException {
        /*
         * Writing to player1's user profile
         * Incrementing games played by 1
         * Only executed is a player's profile is loaded and not the default
         * Guest profile
         */        
        
        if (player1.getUsername().equals("Guest")) {
        } else {
            lines = fh.readFile();
            
            /*
             * Parsing through the file and making sure were reading / updating
             * the correct line in the User Profiles files
             */
            String input = "";
            for (String line : lines) {
                String[] parts = line.split(" ");
                input += line + '\n';
                if (null != parts) switch (parts[0]) {
                    case "GamesPlayed:":       
                        int gamesPlayed = Integer.parseInt(parts[1]);
                        int newGamesPlayed = gamesPlayed+1;
                        input = input.replace("GamesPlayed: " + gamesPlayed, "GamesPlayed: " + newGamesPlayed);
                        break;
                    default:
                        break;
                }
            }
            fh.writeFile(input);
        }
        /**
         * Writing to player2's user profile
         * Incrementing games played by 1
         * Only executed is a player's profile is loaded and not the default
         * Guest profile
         */
        if (player2.getUsername().equals("Guest2") || player2.getUsername().equals("Computer AI")) {
        } else {
            lines = fh2.readFile();
            
            /**
            * Parsing through the file and making sure were reading / updating
            * the correct line in the User Profiles files
            */
            String input = "";
            for (String line : lines) {
                String[] parts = line.split(" ");
                input += line + '\n';
                if (null != parts) switch (parts[0]) {
                    case "GamesPlayed:":       
                        int gamesPlayed = Integer.parseInt(parts[1]);
                        int newGamesPlayed = gamesPlayed+1;
                        input = input.replace("GamesPlayed: " + gamesPlayed, "GamesPlayed: " + newGamesPlayed);
                        break;
                    default:
                        break;
                }
            }
            fh2.writeFile(input);
        }
    }
    
    
    
    /**
     * Menu Bar - Exit Application
     * 
     * Closes the application.
     * Called from the menu item.
     * @param evt 
     */
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        System.exit(0);
    }         
    
    /**
     * Menu bar - Return to Menu.
     * 
     * Returns us to the menu.
     * Called from the menu item.
     * @param evt 
     */
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        goToMenu();
    }         
    
    /**
     * End Turn.
     * 
     * This is a method that is passed all the way down to the lowest level of 
     * the class hierarchy here. 
     * 
     * It is a simple function that swaps the status of the Player so that the
     * Tile knows what his status will be when he is clicked.
     * 
     * @param brdindex - Board index.
     */
    public void endTurn(int brdindex) {
        currentPlayer.switchPlayer();
    }
    
    /**
     * Go to Menu.
     * 
     * Sends us back into the menu
     */
    public void goToMenu() {
        MenuGUI s = new MenuGUI(player1,player2);
        s.setVisible(true);
        dispose();
    }
    
    /**
     * Return Color 1.
     * 
     * @return returns button color 1 
     */
    public Color returnColor1() {
        return player1.getColor1();
    }
    
    /**
     * Return Color 2.
     * 
     * @return returns button color 2 
     */
    public Color returnColor2() {
        return player1.getColor2();    
    }
    
    /**
     * Status Check.
     * 
     * Called after every turn is taken to see if any of the win cases are met. 
     * @throws java.io.IOException thrown if board reaches an invalid state
     */
    public void checkWinner() throws IOException {
        /*
         * count move for X
         */
        if(currentPlayer.returnStatus()==true)
            {countX++;}
        /*
         * count move for O
         */
        if(currentPlayer.returnStatus()==false)
            {countO++;}
        
        String text = (currentPlayer.returnStatus() ? String.format("<html> <font color = 'red'> X &nbsp &nbsp &nbsp %s <font color = 'black'> &nbsp &nbsp &nbsp &nbsp Player's Turn &nbsp &nbsp &nbsp &nbsp <font color = 'black'> %s &nbsp &nbsp &nbsp O </html>", player1.getUsername(), player2.getUsername()) : String.format("<html> <font color = 'black'> X &nbsp &nbsp &nbsp %s <font color = 'black'> &nbsp &nbsp &nbsp &nbsp Player's Turn &nbsp &nbsp &nbsp &nbsp <font color = 'blue'> %s &nbsp &nbsp &nbsp O </html>", player1.getUsername(), player2.getUsername()));
        lbl1.setText(String.format("<html> <font color = 'red'> X: %s <font color = 'black'> &nbsp &nbsp &nbsp &nbsp Player's Turn &nbsp &nbsp &nbsp &nbsp <font color = 'blue'> %s :O </html>", player1.getUsername(), player2.getUsername()));
        lbl1.setText("<html><div style='text-align: center;'>" + text + "</div></html>");  
        /*
         * check overall winner and pass username and score
         */
        bboard.checkWinner(player1.getUsername(), countX, player2.getUsername(), countO);

    }
    
    /**
     * Return Tile Index of Board i
     * 
     * @param i board
     * @param k tile
     * @return Tile
     */
    public Tile returnBoardTile(int i, int k)
    {
        return bboard.GetBrdArray(i).returnTileIndex(k);
    }
    
    /**
     * Returns Board located at i in Bigboard.
     * @param i index
     * @return Board
     */
    public Board returnBoard(int i)
    {
        return bboard.returnIndexBoard(i);
    }
    
    /**
     * Board Manager.
     * Simply calls BigBoard's manageBoard method.
     * 
     * @param EnabledIndex index of tile
     * @param brdIndex index of board
     */
     public void manageBoard(int EnabledIndex, int brdIndex)
    {
        bboard.manageBoard(EnabledIndex, brdIndex);
        if (player1.getGamemode() == 1 && currentPlayer.returnStatus() == false) {
            enemy.pickMove(bboard.GetBrdArray(brdIndex), this);
        }
    }
     
    // Variables declaration - do not modify                     
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    // End of variables declaration             
}
