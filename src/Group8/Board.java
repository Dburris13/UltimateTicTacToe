/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Group8;

import java.awt.*;
import java.applet.Applet;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class Board extends Applet {
    
    private int id;
    private char turn;
    private Color brdColor;
    private Tile[] btnArray = new Tile[9];
    private String brdStatus = ""; 
    
    public Board (Game game, Color color) {
        brdColor = color;
        turn = turn;
        
        GridLayout gl = new GridLayout (3,3,1,1);
        this.setLayout(gl);
                
        for (int i = 0; i < 9; i++) {
            btnArray[i] = new Tile(game, this, turn, brdColor);
            this.add(btnArray[i]);
        }
    }    
    
    public void CheckWinner() {
        
        // Checking if board is full
        if  (btnArray[0].returnStatus() != "" && btnArray[1].returnStatus() != "" && btnArray[2].returnStatus() != ""
            && btnArray[3].returnStatus() != "" && btnArray[4].returnStatus() != "" && btnArray[5].returnStatus() != ""
            && btnArray[6].returnStatus() != "" && btnArray[7].returnStatus() != "" && btnArray[8].returnStatus() != "")
        {
            brdStatus = "T";
            System.out.println("BOARD IS A TIE");
        }     
        
        // Checking if X won
        if (btnArray[0].returnStatus() == "X" && btnArray[1].returnStatus() == "X" && btnArray[2].returnStatus() == "X"
            ||btnArray[3].returnStatus() == "X" && btnArray[4].returnStatus() == "X" && btnArray[5].returnStatus() == "X"
            ||btnArray[6].returnStatus() == "X" && btnArray[7].returnStatus() == "X" && btnArray[8].returnStatus() == "X"
            ||btnArray[0].returnStatus() == "X" && btnArray[3].returnStatus() == "X" && btnArray[6].returnStatus() == "X"
            ||btnArray[1].returnStatus() == "X" && btnArray[4].returnStatus() == "X" && btnArray[7].returnStatus() == "X"
            ||btnArray[2].returnStatus() == "X" && btnArray[5].returnStatus() == "X" && btnArray[8].returnStatus() == "X"
            ||btnArray[0].returnStatus() == "X" && btnArray[4].returnStatus() == "X" && btnArray[8].returnStatus() == "X"
            ||btnArray[2].returnStatus() == "X" && btnArray[4].returnStatus() == "X" && btnArray[6].returnStatus() == "X") 
        {               
            brdStatus = "X";
            System.out.println("BOARD IS A X");
        }
        
        // Checking if O won
        if (btnArray[0].returnStatus() == "O" && btnArray[1].returnStatus() == "O" && btnArray[2].returnStatus() == "O"
            ||btnArray[3].returnStatus() == "O" && btnArray[4].returnStatus() == "O" && btnArray[5].returnStatus() == "O"
            ||btnArray[6].returnStatus() == "O" && btnArray[7].returnStatus() == "O" && btnArray[8].returnStatus() == "O"
            ||btnArray[0].returnStatus() == "O" && btnArray[3].returnStatus() == "O" && btnArray[6].returnStatus() == "O"
            ||btnArray[1].returnStatus() == "O" && btnArray[4].returnStatus() == "O" && btnArray[7].returnStatus() == "O"
            ||btnArray[2].returnStatus() == "O" && btnArray[5].returnStatus() == "O" && btnArray[8].returnStatus() == "O"
            ||btnArray[0].returnStatus() == "O" && btnArray[4].returnStatus() == "O" && btnArray[8].returnStatus() == "O"
            ||btnArray[2].returnStatus() == "O" && btnArray[4].returnStatus() == "O" && btnArray[6].returnStatus() == "O") 
        {            
            brdStatus = "O";
            System.out.println("BOARD IS A O");
        }   
    }    
    
    public String returnStatus() 
    {
        return brdStatus;
    }
    
    public Color returnColor() 
    {
        return brdColor;
    }
    
    public Tile returnIndex_Tile(int index_btnArray)    //return Tile at a specific index of Board
    {
        return btnArray[index_btnArray];
    }
   
}
