/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Group8;

import java.awt.*;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


/**
 *
 * @author Daniel
 */
public class Tile extends JButton implements ActionListener {
    //private JButton btn = new JButton();
    private int BTN_SIZE = 70;
    private char btnText = ' ';
    private boolean whoseTurn; 
    private Game game;
    private Board brd;
    private int tileIndex =0, brdIndex = 0;
    
    public Tile(Game game, Board brd, char turn, Color color) {
        this.setSize(BTN_SIZE, BTN_SIZE);
        this.addActionListener(this);
        this.setActionCommand("Geeks");
        this.setBackground(color);
        this.setForeground(Color.PINK);
        this.game = game;
        this.brd = brd;
        btnText = turn;
    }
    
    public String returnStatus() {
        System.out.println("Button is : " + getText());
        return getText();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        for(int i =0; i<9; i++) //loop to check which Tile is being pressed
        {
            for(int k =0; k<9; k++)
            {
            if(ae.getSource() == game.return_Board_Tile(i, k))
                {
                //JOptionPane.showMessageDialog(null, "at board: "+i+" tile: "+k);
                tileIndex = k;
                brdIndex = i;
            }
            }
        }
        if (action.equals("Geeks")) {
            this.setFont(new Font("Arial", Font.PLAIN, 40));
            this.setText((game.currentPlayer.returnStatus() ? "X" : "O"));
           // this.setEnabled(false);
            game.endTurn();
            game.checkWinner();
            game.Disabled_EnabledBoard(tileIndex, brdIndex); //set where to go if Tile clicked
        }
    }
}
