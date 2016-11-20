package Group8;

import GUIStuff.WinDialog;
import java.awt.*;
import java.applet.Applet;
import javax.swing.JOptionPane;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * This class is the BigBoard class that encapsulates 9 Board classes.
 * It is the 2nd highest level of our game's hierarchy. It is responsible
 * for checking its own win cases and visually identifying winning boards
 * to the user.
 * 
 * It determine whether the game has been won with its checkWinner() function.
 * 
 * It talks to all 9 of it's sub-boards to see what their return status is and
 * paints the board appropriately. It will also paint the boards based on which board is
 * active and which board is not. 
 * 
 * It also handles the ranking system information.
 * 
 * @author Daniel
 * @author Ben
 */
public class BigBoard extends Applet  {
    private String turn;
    public Board[] brdArray = new Board[9];
    private Game game;
        
    /** 
     * Default Constructor 
     * The whole game scene is interconnected with each other.
     * @param game 
     */
    public BigBoard (Game game) {
        /**
         * The BigBoard itself is just a GridLayout. 
         * It places 9 Boards into each of its grid slots.
         */
        GridLayout gl = new GridLayout (3,3, 3, 3);
        this.setLayout(gl);
        this.game = game;
                
        /**
         * This FOR loop creates 9 boards that are placed into the 3x3 grid layout
         */
        for (int i = 0; i < 9; i++) {
            brdArray[i] = new Board(game, (evenNumber(i) ? game.returnColor1() : game.returnColor2()));
            this.add(brdArray[i]);
        }        
    }
    
    /**
     * This is a general method that determines if num is even.
     * @param num integer passed into method
     * @return true is num is even
     */
    private boolean evenNumber (int num) {
        if (num%2 == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * This method is called by the game scene when after each turn to determine whether the game has been won.
     * This function simply just looks at its 9 boards and calls their checkWinner functions. 
     * It then compares their statuses to each other to see what status it should return to game.
     * 
     * 
     * @param user1 player1's name
     * @param score1 player1's score count
     * @param user2 player2's name
     * @param score2 player2's score count
     */
    public void checkWinner(String user1, int score1, String user2, int score2) {
        /**
         * Grabbing the status of all 9 boards
         */
        for (int i = 0; i < 9; i++) {
            brdArray[i].checkWinner();
        }
        
        /**
         * Looking at all win cases for X
         */
        if (brdArray[0].returnStatus() == "X" && brdArray[1].returnStatus() == "X" && brdArray[2].returnStatus() == "X"
            ||brdArray[3].returnStatus() == "X" && brdArray[4].returnStatus() == "X" && brdArray[5].returnStatus() == "X"
            ||brdArray[6].returnStatus() == "X" && brdArray[7].returnStatus() == "X" && brdArray[8].returnStatus() == "X"
            ||brdArray[0].returnStatus() == "X" && brdArray[3].returnStatus() == "X" && brdArray[6].returnStatus() == "X"
            ||brdArray[1].returnStatus() == "X" && brdArray[4].returnStatus() == "X" && brdArray[7].returnStatus() == "X"
            ||brdArray[2].returnStatus() == "X" && brdArray[5].returnStatus() == "X" && brdArray[8].returnStatus() == "X"
            ||brdArray[0].returnStatus() == "X" && brdArray[4].returnStatus() == "X" && brdArray[8].returnStatus() == "X"
            ||brdArray[2].returnStatus() == "X" && brdArray[4].returnStatus() == "X" && brdArray[6].returnStatus() == "X") {
            //JOptionPane.showMessageDialog(null,"THE WINNER: "+user1+"  total move: "+score1 );
            UserToRank(user1,score1);
            WinDialog w = new WinDialog(game,game,user1,score1);
            w.setVisible(true);
            //game.goToMenu();
        }
        
        /**
         * Looking at all win cases for O
         */
        if (brdArray[0].returnStatus() == "O" && brdArray[1].returnStatus() == "O" && brdArray[2].returnStatus() == "O"
            ||brdArray[3].returnStatus() == "O" && brdArray[4].returnStatus() == "O" && brdArray[5].returnStatus() == "O"
            ||brdArray[6].returnStatus() == "O" && brdArray[7].returnStatus() == "O" && brdArray[8].returnStatus() == "O"
            ||brdArray[0].returnStatus() == "O" && brdArray[3].returnStatus() == "O" && brdArray[6].returnStatus() == "O"
            ||brdArray[1].returnStatus() == "O" && brdArray[4].returnStatus() == "O" && brdArray[7].returnStatus() == "O"
            ||brdArray[2].returnStatus() == "O" && brdArray[5].returnStatus() == "O" && brdArray[8].returnStatus() == "O"
            ||brdArray[0].returnStatus() == "O" && brdArray[4].returnStatus() == "O" && brdArray[8].returnStatus() == "O"
            ||brdArray[2].returnStatus() == "O" && brdArray[4].returnStatus() == "O" && brdArray[6].returnStatus() == "O") {            
            //JOptionPane.showMessageDialog(null, "THE WINNER: "+user2+"  total move: "+score2);
            UserToRank(user2, score2);
            WinDialog w = new WinDialog(game,game,user2,score2);
            w.setVisible(true);
            //game.dispose();
            //game.goToMenu();
        }           
    }
    
    /**
     * This methods paints an entire board like an X character 
     * 
     * @param brd board to be painted
     */
    private void paintX(Board brd) {
        
        /**
         *  |X| |X|
         *  | |X| |
         *  |X| |X| 
         */
        brd.returnTileIndex(0).setBackground(Color.red);
        brd.returnTileIndex(1).setBackground(Color.BLACK);
        brd.returnTileIndex(2).setBackground(Color.red);
        brd.returnTileIndex(3).setBackground(Color.BLACK);
        brd.returnTileIndex(4).setBackground(Color.red);
        brd.returnTileIndex(5).setBackground(Color.BLACK);
        brd.returnTileIndex(6).setBackground(Color.red);
        brd.returnTileIndex(7).setBackground(Color.BLACK);
        brd.returnTileIndex(8).setBackground(Color.red);
        
        /** 
         * FIXFIX
         * Should maintain the colors of the Icon text
         */
        for (int i = 0; i < 9; i++) {
            brd.returnTileIndex(i).setForeground(Color.PINK);
        }
        
        /**
         * board has been won and is no longer playable
         */
        brd.returnTileIndex(0).setEnabled(false);
        brd.returnTileIndex(1).setEnabled(false);
        brd.returnTileIndex(2).setEnabled(false);
        brd.returnTileIndex(3).setEnabled(false);
        brd.returnTileIndex(4).setEnabled(false);
        brd.returnTileIndex(5).setEnabled(false);
        brd.returnTileIndex(6).setEnabled(false);
        brd.returnTileIndex(7).setEnabled(false);
        brd.returnTileIndex(8).setEnabled(false);          
    }
    
    /**
     * This methods paints an entire board to RED, to signify that the board is a tie. 
     * 
     * @param brd board to be painted
     */
    private void paintR(Board brd) {
        
        /**
         *  |R|R|R|
         *  |R|R|R|
         *  |R|R|R| 
         */
        brd.returnTileIndex(0).setBackground(Color.red);
        brd.returnTileIndex(1).setBackground(Color.red);
        brd.returnTileIndex(2).setBackground(Color.red);
        brd.returnTileIndex(3).setBackground(Color.red);
        brd.returnTileIndex(4).setBackground(Color.red);
        brd.returnTileIndex(5).setBackground(Color.red);
        brd.returnTileIndex(6).setBackground(Color.red);
        brd.returnTileIndex(7).setBackground(Color.red);
        brd.returnTileIndex(8).setBackground(Color.red);  
        
        /** 
         * FIXFIX
         * Should maintain the colors of the Icon text
         */
        for (int i = 0; i < 9; i++) {
            brd.returnTileIndex(i).setForeground(Color.PINK);
        }      
        
        /**
         * board has been won and is no longer playable
         */
        brd.returnTileIndex(0).setEnabled(false);
        brd.returnTileIndex(1).setEnabled(false);
        brd.returnTileIndex(2).setEnabled(false);
        brd.returnTileIndex(3).setEnabled(false);
        brd.returnTileIndex(4).setEnabled(false);
        brd.returnTileIndex(5).setEnabled(false);
        brd.returnTileIndex(6).setEnabled(false);
        brd.returnTileIndex(7).setEnabled(false);
        brd.returnTileIndex(8).setEnabled(false);        
    }
    
    /**
     * This methods paints an entire board like an O character 
     * 
     * @param brd board to be painted
     */    
    private void paintO(Board brd) {
        /**
         *  |O|O|O|
         *  |O| |O|
         *  |O|O|O| 
         */
        brd.returnTileIndex(0).setBackground(Color.red);
        brd.returnTileIndex(1).setBackground(Color.red);
        brd.returnTileIndex(2).setBackground(Color.red);
        brd.returnTileIndex(3).setBackground(Color.red);
        brd.returnTileIndex(4).setBackground(Color.black);
        brd.returnTileIndex(5).setBackground(Color.red);
        brd.returnTileIndex(6).setBackground(Color.red);
        brd.returnTileIndex(7).setBackground(Color.red);
        brd.returnTileIndex(8).setBackground(Color.red); 
        
        /** 
         * FIXFIX
         * Should maintain the colors of the Icon text
         */
        for (int i = 0; i < 9; i++) {
            brd.returnTileIndex(i).setForeground(Color.PINK);
        }        
        
        /**
         * board has been won and is no longer playable
         */
        brd.returnTileIndex(0).setEnabled(false);
        brd.returnTileIndex(1).setEnabled(false);
        brd.returnTileIndex(2).setEnabled(false);
        brd.returnTileIndex(3).setEnabled(false);
        brd.returnTileIndex(4).setEnabled(false);
        brd.returnTileIndex(5).setEnabled(false);
        brd.returnTileIndex(6).setEnabled(false);
        brd.returnTileIndex(7).setEnabled(false);
        brd.returnTileIndex(8).setEnabled(false);        
    }
    /**
     * This function handles the painting of the BigBoard class.
     * 
     * It has many responsibilities. The board is originally painted when BigBoard is created.
     * This method has to repaint the board after every turn depending on which board is active,
     * which boards have been won or tied, and which tiles are active in each board. 
     * 
     * 
     * @param tileIndex passes the tile were working with
     * @param brdIndex passes the board were working with
     */
    public void manageBoard(int tileIndex, int brdIndex) 
    {
        /**
         * This variable grabs the color of the board
         */
        Color oldColor = brdArray[tileIndex].returnColor();
        
        /**
         * If the next board has already been won
         */
        if (brdArray[tileIndex].returnStatus() == "X" || brdArray[tileIndex].returnStatus() == "O" || brdArray[tileIndex].returnStatus() == "T") {
            for(int i =0; i<9; i++) {
                oldColor = brdArray[i].returnColor();
                // Start by enabling everything
                brdArray[i].setEnabled(true);            
                // Changing all disabled tiles to dark_gray
                for(int k =0; k<9; k++) {
                    brdArray[i].returnTileIndex(k).setBackground(oldColor);
                    brdArray[i].returnTileIndex(k).setForeground(Color.PINK);
                }
            }
            
            /**
             * This FOR loop now re-enables the next board if it hasn't been closed because it was already won.
             */
            for(int i = 0; i < 9; i++) { 
                /**
                 * Grabbing appropriate board color
                 */
                if (brdArray[i].returnStatus() == "X") {
                    paintX(brdArray[i]);
                } else if (brdArray[i].returnStatus() == "O") {
                    paintO(brdArray[i]);
                } else if (brdArray[i].returnStatus() == "T") {
                    paintR(brdArray[i]);
                }
            }       
        } else { 
            /**
             * This first FOR loop disables all 9 boards, and visually 
             */
            for(int i =0; i<9; i++) {
                /**
                 * Start by disabling everything
                 */
                brdArray[i].setEnabled(false);            
                /**
                 * Changing all disabled tiles to dark_gray
                 */
                for(int k =0; k<9; k++) {
                    brdArray[i].returnTileIndex(k).setBackground(Color.DARK_GRAY);
                    brdArray[i].returnTileIndex(k).setForeground(Color.PINK);
                }
            }

            /**
             * Don't disable the next board we play on
             */
            brdArray[tileIndex].setEnabled(true);
            for(int k =0; k<9; k++)
            {
                brdArray[tileIndex].returnTileIndex(k).setBackground(oldColor);
                brdArray[tileIndex].returnTileIndex(k).setForeground(Color.PINK);
            }

            /**
             * This FOR loop now re-enables the next board if it hasn't been closed because it was already won.
             */
            for(int i = 0; i < 9; i++) { 
                /**
                 * Grabbing appropriate board color
                 */
                if (brdArray[i].returnStatus() == "X") {
                    paintX(brdArray[i]);
                } else if (brdArray[i].returnStatus() == "O") {
                    paintO(brdArray[i]);
                } else if (brdArray[i].returnStatus() == "T") {
                    paintR(brdArray[i]);
                }
            }            
        }
        
        /**
         * This FOR loops looks at the selected board and determines which buttons
         * have not been pressed yet
         */
        for (int i = 0; i < 9; i++) {
            for(int j =0; j<9; j++) {    
                if(brdArray[i].returnTileIndex(j).returnStatus() == "X") {
                    brdArray[i].returnTileIndex(j).setEnabled(false);
                } else if (brdArray[i].returnTileIndex(j).returnStatus() == "O")
                {
                    brdArray[i].returnTileIndex(j).setEnabled(false);
                }
            }
        }
    }
    
    /**
     * return boardArray at specific index
     * @param btnArrayIndex
     * @return 
     */
    public Board returnIndex_Board(int btnArrayIndex) 
    {
        return brdArray[btnArrayIndex];
    }
    
    /**
     * add winner to ranking system database rank.data file
     * @param name
     * @param score 
     */
    public void UserToRank(String name, int score)
    {
     try
    {
        String path = "Rank.data";

        File file = new File(path);

        FileWriter fileWriter = new FileWriter(file,true);

        BufferedWriter bufferFileWriter  = new BufferedWriter(fileWriter);

        fileWriter.append(name+","+score);

        bufferFileWriter.close();

    }catch(Exception ex)
    {
        System.out.println(ex);
    }
    }
}
