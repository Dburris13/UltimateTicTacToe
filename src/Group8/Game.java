/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Group8;

import java.awt.*;
import java.applet.Applet;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.*;

public class Game extends JFrame{
        
    public Player currentPlayer = new Player(true);
    private BigBoard bboard;
    private Color c1, c2;
    private JLabel lbl1 = new JLabel();
    private String username1 = "";
    private String username2 = "";
    private int count_X=0;
    private int count_O=0;
    private UserInfo userInfo;
    private UserInfo userInfo2;    
    
    public Game() {
        userInfo = new UserInfo();
        userInfo2 = new UserInfo();        
        initGame();   
        updateUserProfile();     
    }
    
    public Game(UserInfo user1, UserInfo user2) {
        userInfo = user1;
        userInfo2 = user2;
        this.c1 = user1.getColor1();
        this.c2 = user1.getColor2();
        this.username1 = user1.getUsername();
        this.userInfo = user1;
        this.username2 = user2.getUsername();
        this.userInfo2 = user2;
        initGame();   
        updateUserProfile();     
    }
    
    private void initGame() {
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(userInfo.getResolution());
        BorderLayout bL = new BorderLayout(5,5);
        this.setLayout(bL);
         
       
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Return to Menu");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });        
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1); 
        bboard = new BigBoard(this);
        Dimension dim = new Dimension(720,480);
        bboard.setSize(dim);
        lbl1.setText("Player's Turn: " + (currentPlayer.returnStatus() ? "X": "O") + "     " + "Username: " + username1);    
        
        //bL.addLayoutComponent(lbl1, 1);
        this.add(lbl1, bL.NORTH);
        this.add(bboard, bL.CENTER);
        this.setLocationRelativeTo(null);
       // bL.addLayoutComponent(bboard, SOMEBITS);
       // this.add(lbl1);
       // this.add(bboard);  
    }
    
    private void updateUserProfile() {
        String filePathString = "userProfiles/" + username1;
        File f = new File(filePathString);
        
        if (f.exists()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(f));
                String line;String input = "";    
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(" ");
                    input += line + '\n';       
                    
                    if (parts[1].matches("Played:")) {
                        int gamesPlayed = Integer.parseInt(parts[2]);
                        int newGamesPlayed = gamesPlayed+1;
                        input = input.replace("Games Played: " + gamesPlayed, "Games Played: " + newGamesPlayed);
                        
                         // check if the new input is right
                        System.out.println("----------------------------------"  + '\n' + input);
                    }
                    
                    FileOutputStream fileOut = new FileOutputStream(filePathString);
                    fileOut.write(input.getBytes());
                    fileOut.close();
                }
            } catch (IOException x) {
                System.err.format("IOException: %s%n", x);
            } 
        }      
    }
    
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        System.exit(0);
    }         
    
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        goToMenu();
    }         
    
    public void endTurn() {
        currentPlayer.switchPlayer();
    }
    
    public void goToMenu() {
        MenuGUI s = new MenuGUI(userInfo,userInfo2);
        s.setVisible(true);
        dispose();
    }
    
    public Color returnColor1() {
        return c1;    
    }
    
    public Color returnColor2() {
        return c2;    
    }
    
    public void checkWinner() {
        //count move for X
        if(currentPlayer.returnStatus()==true)
            {count_X++;}
        //count move for O
        if(currentPlayer.returnStatus()==false)
            {count_O++;}
        
        lbl1.setText("Player's Turn: " + (currentPlayer.returnStatus() ? "X     "+"UserName: "+username1 +"     Total move: "+count_X : "O     "+"UserName: "+username2 + "     Total move: "+count_O));  
        //check overall winner and pass username and score
        bboard.CheckWinner(username1, count_X, username2, count_O);

    }
    public void checkTile()
    {
        //bboard.CheckTile();
    }
    public Tile return_Board_Tile(int i, int k)
    {
        return bboard.brdArray[i].returnIndex_Tile(k);
    }
    
     public void Disabled_EnabledBoard(int Enabled_index, int brdIndex)
    {
        bboard.Disabled_EnabledBoard(Enabled_index, brdIndex);
    }
     
    // Variables declaration - do not modify                     
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    // End of variables declaration             
}
