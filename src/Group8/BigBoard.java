/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Group8;

import java.awt.*;
import java.applet.Applet;
import javax.swing.JOptionPane;

public class BigBoard extends Applet  {
    private String turn;
    public Board[] brdArray = new Board[9];
    private Game game;
        
    public BigBoard (Game game) {
        GridLayout gl = new GridLayout (3,3, 3, 3);
        this.setLayout(gl);
        this.game = game;
        Dimension dim = new Dimension(720, 480);
        this.setMaximumSize(dim);
                
        for (int i = 0; i < 9; i++) {
            brdArray[i] = new Board(game, (evenNumber(i) ? game.returnColor1() : game.returnColor2()));
            this.add(brdArray[i]);
        }        
    }
    
    private boolean evenNumber (int num) {
        if (num%2 == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public void CheckWinner() {
        for (int i = 0; i < 9; i++) {
            brdArray[i].CheckWinner();
        }
        
        if (brdArray[0].returnStatus() == "X" && brdArray[1].returnStatus() == "X" && brdArray[2].returnStatus() == "X"
            ||brdArray[3].returnStatus() == "X" && brdArray[4].returnStatus() == "X" && brdArray[5].returnStatus() == "X"
            ||brdArray[6].returnStatus() == "X" && brdArray[7].returnStatus() == "X" && brdArray[8].returnStatus() == "X"
            ||brdArray[0].returnStatus() == "X" && brdArray[3].returnStatus() == "X" && brdArray[6].returnStatus() == "X"
            ||brdArray[1].returnStatus() == "X" && brdArray[4].returnStatus() == "X" && brdArray[7].returnStatus() == "X"
            ||brdArray[2].returnStatus() == "X" && brdArray[5].returnStatus() == "X" && brdArray[8].returnStatus() == "X"
            ||brdArray[0].returnStatus() == "X" && brdArray[4].returnStatus() == "X" && brdArray[8].returnStatus() == "X"
            ||brdArray[2].returnStatus() == "X" && brdArray[4].returnStatus() == "X" && brdArray[6].returnStatus() == "X") {
            JOptionPane.showMessageDialog(null, "X IS THE WINNER");
            game.goToMenu();
        }
        
        if (brdArray[0].returnStatus() == "O" && brdArray[1].returnStatus() == "O" && brdArray[2].returnStatus() == "O"
            ||brdArray[3].returnStatus() == "O" && brdArray[4].returnStatus() == "O" && brdArray[5].returnStatus() == "O"
            ||brdArray[6].returnStatus() == "O" && brdArray[7].returnStatus() == "O" && brdArray[8].returnStatus() == "O"
            ||brdArray[0].returnStatus() == "O" && brdArray[3].returnStatus() == "O" && brdArray[6].returnStatus() == "O"
            ||brdArray[1].returnStatus() == "O" && brdArray[4].returnStatus() == "O" && brdArray[7].returnStatus() == "O"
            ||brdArray[2].returnStatus() == "O" && brdArray[5].returnStatus() == "O" && brdArray[8].returnStatus() == "O"
            ||brdArray[0].returnStatus() == "O" && brdArray[4].returnStatus() == "O" && brdArray[8].returnStatus() == "O"
            ||brdArray[2].returnStatus() == "O" && brdArray[4].returnStatus() == "O" && brdArray[6].returnStatus() == "O") {            
            JOptionPane.showMessageDialog(null, "O IS THE WINNER");
            game.goToMenu();
        }           
    }
    
    private void paintX(Board brd) {
        brd.returnIndex_Tile(0).setBackground(Color.red);
        brd.returnIndex_Tile(1).setBackground(Color.BLACK);
        brd.returnIndex_Tile(2).setBackground(Color.red);
        brd.returnIndex_Tile(3).setBackground(Color.BLACK);
        brd.returnIndex_Tile(4).setBackground(Color.red);
        brd.returnIndex_Tile(5).setBackground(Color.BLACK);
        brd.returnIndex_Tile(6).setBackground(Color.red);
        brd.returnIndex_Tile(7).setBackground(Color.BLACK);
        brd.returnIndex_Tile(8).setBackground(Color.red);
        
        for (int i = 0; i < 9; i++) {
            brd.returnIndex_Tile(i).setForeground(Color.PINK);
        }
        
        brd.returnIndex_Tile(0).setEnabled(false);
        brd.returnIndex_Tile(1).setEnabled(false);
        brd.returnIndex_Tile(2).setEnabled(false);
        brd.returnIndex_Tile(3).setEnabled(false);
        brd.returnIndex_Tile(4).setEnabled(false);
        brd.returnIndex_Tile(5).setEnabled(false);
        brd.returnIndex_Tile(6).setEnabled(false);
        brd.returnIndex_Tile(7).setEnabled(false);
        brd.returnIndex_Tile(8).setEnabled(false);          
    }
    
    private void paintR(Board brd) {
        brd.returnIndex_Tile(0).setBackground(Color.red);
        brd.returnIndex_Tile(1).setBackground(Color.red);
        brd.returnIndex_Tile(2).setBackground(Color.red);
        brd.returnIndex_Tile(3).setBackground(Color.red);
        brd.returnIndex_Tile(4).setBackground(Color.red);
        brd.returnIndex_Tile(5).setBackground(Color.red);
        brd.returnIndex_Tile(6).setBackground(Color.red);
        brd.returnIndex_Tile(7).setBackground(Color.red);
        brd.returnIndex_Tile(8).setBackground(Color.red);    
        
        for (int i = 0; i < 9; i++) {
            brd.returnIndex_Tile(i).setForeground(Color.PINK);
        }        
        
        brd.returnIndex_Tile(0).setEnabled(false);
        brd.returnIndex_Tile(1).setEnabled(false);
        brd.returnIndex_Tile(2).setEnabled(false);
        brd.returnIndex_Tile(3).setEnabled(false);
        brd.returnIndex_Tile(4).setEnabled(false);
        brd.returnIndex_Tile(5).setEnabled(false);
        brd.returnIndex_Tile(6).setEnabled(false);
        brd.returnIndex_Tile(7).setEnabled(false);
        brd.returnIndex_Tile(8).setEnabled(false);        
    }
    
    private void paintO(Board brd) {
        brd.returnIndex_Tile(0).setBackground(Color.red);
        brd.returnIndex_Tile(1).setBackground(Color.red);
        brd.returnIndex_Tile(2).setBackground(Color.red);
        brd.returnIndex_Tile(3).setBackground(Color.red);
        brd.returnIndex_Tile(4).setBackground(Color.black);
        brd.returnIndex_Tile(5).setBackground(Color.red);
        brd.returnIndex_Tile(6).setBackground(Color.red);
        brd.returnIndex_Tile(7).setBackground(Color.red);
        brd.returnIndex_Tile(8).setBackground(Color.red);    
        
        for (int i = 0; i < 9; i++) {
            brd.returnIndex_Tile(i).setForeground(Color.PINK);
        }        
        
        brd.returnIndex_Tile(0).setEnabled(false);
        brd.returnIndex_Tile(1).setEnabled(false);
        brd.returnIndex_Tile(2).setEnabled(false);
        brd.returnIndex_Tile(3).setEnabled(false);
        brd.returnIndex_Tile(4).setEnabled(false);
        brd.returnIndex_Tile(5).setEnabled(false);
        brd.returnIndex_Tile(6).setEnabled(false);
        brd.returnIndex_Tile(7).setEnabled(false);
        brd.returnIndex_Tile(8).setEnabled(false);        
    }
    
    private void paintT(Board brd) {
        brd.returnIndex_Tile(0).setBackground(Color.red);
        brd.returnIndex_Tile(1).setBackground(Color.red);
        brd.returnIndex_Tile(2).setBackground(Color.red);
        brd.returnIndex_Tile(3).setBackground(Color.red);
        brd.returnIndex_Tile(4).setBackground(Color.red);
        brd.returnIndex_Tile(5).setBackground(Color.red);
        brd.returnIndex_Tile(6).setBackground(Color.red);
        brd.returnIndex_Tile(7).setBackground(Color.red);
        brd.returnIndex_Tile(8).setBackground(Color.red);    
        
        for (int i = 0; i < 9; i++) {
            brd.returnIndex_Tile(i).setForeground(Color.PINK);
        }        
        
        brd.returnIndex_Tile(0).setEnabled(false);
        brd.returnIndex_Tile(1).setEnabled(false);
        brd.returnIndex_Tile(2).setEnabled(false);
        brd.returnIndex_Tile(3).setEnabled(false);
        brd.returnIndex_Tile(4).setEnabled(false);
        brd.returnIndex_Tile(5).setEnabled(false);
        brd.returnIndex_Tile(6).setEnabled(false);
        brd.returnIndex_Tile(7).setEnabled(false);
        brd.returnIndex_Tile(8).setEnabled(false);        
    }    
    
    public void Disabled_EnabledBoard(int tileIndex, int brdIndex) 
    {
        // This variable grabs the color of the board
        Color oldColor = brdArray[tileIndex].returnColor();
        
        // If the next board has already been won
        if (brdArray[tileIndex].returnStatus() == "X" || brdArray[tileIndex].returnStatus() == "O" || brdArray[tileIndex].returnStatus() == "T") {
            for(int i =0; i<9; i++) {
                oldColor = brdArray[i].returnColor();
                // Start by enabling everything
                brdArray[i].setEnabled(true);            
                // Changing all disabled tiles to dark_gray
                for(int k =0; k<9; k++) {
                    brdArray[i].returnIndex_Tile(k).setBackground(oldColor);
                    brdArray[i].returnIndex_Tile(k).setForeground(Color.PINK);
                }
            }
            
            // This FOR loop now re-enables the next board if it hasn't been closed because it was already won.
            for(int i = 0; i < 9; i++) { // Looping through all nine boards
                // Grabbing appropriate board color
                if (brdArray[i].returnStatus() == "X") {
                    paintX(brdArray[i]);
                } else if (brdArray[i].returnStatus() == "O") {
                    paintO(brdArray[i]);
                } else if (brdArray[i].returnStatus() == "T") {
                    paintR(brdArray[i]);
                }
            }       
        } else { // If the next board hasn't already been won
            // This first FOR loop disables all 9 boards, and visually 
            for(int i =0; i<9; i++) {
                // Start by disabling everything
                brdArray[i].setEnabled(false);            
                // Changing all disabled tiles to dark_gray
                for(int k =0; k<9; k++) {
                    brdArray[i].returnIndex_Tile(k).setBackground(Color.DARK_GRAY);
                    brdArray[i].returnIndex_Tile(k).setForeground(Color.PINK);
                }
            }

            // Don't disable the next board we play on
            brdArray[tileIndex].setEnabled(true);
            for(int k =0; k<9; k++)
            {
                brdArray[tileIndex].returnIndex_Tile(k).setBackground(oldColor);
                brdArray[tileIndex].returnIndex_Tile(k).setForeground(Color.PINK);
            }

            // This FOR loop now re-enables the next board if it hasn't been closed because it was already won.
            for(int i = 0; i < 9; i++) { // Looping through all nine boards
                // Grabbing appropriate board color
                if (brdArray[i].returnStatus() == "X") {
                    paintX(brdArray[i]);
                } else if (brdArray[i].returnStatus() == "O") {
                    paintO(brdArray[i]);
                } else if (brdArray[i].returnStatus() == "T") {
                    paintR(brdArray[i]);
                }
            }            
        }
        
        // This FOR loops looks at the selected board and determines which buttons
        // have not been pressed yet
        for (int i = 0; i < 9; i++) {
            for(int j =0; j<9; j++) {    
                if(brdArray[i].returnIndex_Tile(j).returnStatus() == "X") {
                    brdArray[i].returnIndex_Tile(j).setEnabled(false);
                } else if (brdArray[i].returnIndex_Tile(j).returnStatus() == "O")
                {
                    brdArray[i].returnIndex_Tile(j).setEnabled(false);
                }
            }
        }
    }
    public Board returnIndex_Board(int index_btnArray) //return boardArray at specific index
    {
        return brdArray[index_btnArray];
    }
}
