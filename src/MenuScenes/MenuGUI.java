/* 
 * CS321 - Java Programming
 * Final Project - Team 8 - Ultimate Tic-Tac-Toe
 * 
 * Members:
 * Daniel, Ben, Irene, Zach
 */
package MenuScenes;

import GUIStuff.AnimatedPanel;
import Group8.Game;
import Group8.Settings;
import Group8.UserInfo;
import java.awt.Color;

/**
 * This class represents our main menu scene.
 * This class features 4 jButtons which each take you into another scene and 1
 * jButton which exits the application. It also features 4 radio buttons to 
 * allow the user to select between an AI opponent or player opponent. It will
 * also display the current profiles loaded into the game.
 * 
 * @author Daniel
 * @author Irene
 * 
 */
public class MenuGUI extends javax.swing.JFrame {
 
    /**
     * Stored information for player 1
     */
    private UserInfo user1;
    
    /** 
     * Stores information for player 2 (if exists)
     */
    private UserInfo user2;   

    /**
     * Default Constructor, called on application start
     */
    public MenuGUI() {
        /**
         * Creates two "Guest" users by default, these are replaced when user profiles are loaded
         */
       user1 = new UserInfo("Guest");
       user2 = new UserInfo("Guest2");  
       /**
        * Creates a jPanel that is behind the menu
        */
       this.setContentPane(new AnimatedPanel());
       initComponents();
       /**
        * Sets the background color
        */
       this.getContentPane().setBackground(Color.decode( "#d4f4dd" )); 
       
       /**
        * This sets the window to the center of the monitor screen
        */
       this.setLocationRelativeTo(null);
       
       /**
        * By default the 2 player radio button is checked since the AI is probably gonna suck
        */
       this.radioPlayer.setSelected(true);
       
       /** 
        * Sets the EditTexts to display the usernames of the current profiles loaded,
        * these will always be Guest and Guest2 on startup
        */
       txtFieldPlayer1.setText(user1.getUsername());
       txtFieldPlayer2.setText(user2.getUsername());
    }
    
    /**
     * Non-default constructor
     * Every scene in our application has this form of constructor
     * It is used so that we can all pass around general menu / game information
     * 
     * @param profile1 contains all information for player 1
     * @param profile2 contains all information for player 2
     * 
     */
    public MenuGUI(UserInfo profile1, UserInfo profile2) {
        this.user1 = profile1;
        this.user2 = profile2;
        
        /**
        * Creates a jPanel that is behind the menu
        */
        this.setContentPane(new AnimatedPanel());
        initComponents();
        
        /**
        * This sets the window to the center of the monitor screen
        */
        this.setLocationRelativeTo(null);
        
        /**
         * sets the background color  
         */
        this.getContentPane().setBackground(Color.decode( "#d4f4dd" ));      
        
        /**
         * When returning to the menu scene, we want to make sure that main menu displays the correct game configuration
         */
        if (user1.getGamemode() == 1) {
            this.radioComputer.setSelected(true);
            txtFieldPlayer2.setVisible(false);
        } else {
            this.radioPlayer.setSelected(true);
            txtFieldPlayer2.setVisible(true);
            this.txtFieldPlayer1.setText(user1.getUsername());
            this.txtFieldPlayer2.setText(user2.getUsername());
        }
    }    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupVersus = new javax.swing.ButtonGroup();
        jPanelMainMenu = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        txtFieldPlayer1 = new javax.swing.JTextField();
        lblVersus = new javax.swing.JLabel();
        btnStart = new javax.swing.JButton();
        btnSettings = new javax.swing.JButton();
        btnQuit = new javax.swing.JButton();
        radioComputer = new javax.swing.JRadioButton();
        txtFieldPlayer2 = new javax.swing.JTextField();
        radioPlayer = new javax.swing.JRadioButton();
        btnProfiles = new javax.swing.JButton();
        btnRank = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelMainMenu.setOpaque(false);
        jPanelMainMenu.setLayout(null);

        lblTitle.setFont(new java.awt.Font("Tempus Sans ITC", 1, 48)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Ultimate TIC TAC TOE");
        jPanelMainMenu.add(lblTitle);
        lblTitle.setBounds(129, 35, 525, 64);

        lblUsername.setText("User Name: ");
        jPanelMainMenu.add(lblUsername);
        lblUsername.setBounds(184, 120, 59, 14);

        txtFieldPlayer1.setText("Player1");
        txtFieldPlayer1.setEditable(false);
        txtFieldPlayer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldPlayer1ActionPerformed(evt);
            }
        });
        jPanelMainMenu.add(txtFieldPlayer1);
        txtFieldPlayer1.setBounds(318, 117, 111, 20);

        lblVersus.setText("Versus:");
        jPanelMainMenu.add(lblVersus);
        lblVersus.setBounds(184, 159, 36, 14);

        btnStart.setText("Start Game");
        btnStart.setToolTipText("");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });
        jPanelMainMenu.add(btnStart);
        btnStart.setBounds(129, 209, 525, 23);

        btnSettings.setText("Settings");
        btnSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSettingsActionPerformed(evt);
            }
        });
        jPanelMainMenu.add(btnSettings);
        btnSettings.setBounds(129, 318, 525, 23);

        btnQuit.setText("Quit");
        btnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitActionPerformed(evt);
            }
        });
        jPanelMainMenu.add(btnQuit);
        btnQuit.setBounds(129, 352, 525, 23);

        btnGroupVersus.add(radioComputer);
        radioComputer.setText("Computer");
        radioComputer.setOpaque(false);
        radioComputer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioComputerActionPerformed(evt);
            }
        });
        jPanelMainMenu.add(radioComputer);
        radioComputer.setBounds(297, 155, 111, 23);

        txtFieldPlayer2.setEditable(false);
        txtFieldPlayer2.setText("Player2");
        txtFieldPlayer2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldPlayer2ActionPerformed(evt);
            }
        });
        jPanelMainMenu.add(txtFieldPlayer2);
        txtFieldPlayer2.setBounds(447, 117, 111, 20);

        btnGroupVersus.add(radioPlayer);
        radioPlayer.setText("Player");
        radioPlayer.setMaximumSize(new java.awt.Dimension(103, 29));
        radioPlayer.setMinimumSize(new java.awt.Dimension(103, 29));
        radioPlayer.setOpaque(false);
        radioPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioPlayerActionPerformed(evt);
            }
        });
        jPanelMainMenu.add(radioPlayer);
        radioPlayer.setBounds(447, 155, 111, 23);

        btnProfiles.setText("User Profiles");
        btnProfiles.setToolTipText("");
        btnProfiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfilesActionPerformed(evt);
            }
        });
        jPanelMainMenu.add(btnProfiles);
        btnProfiles.setBounds(129, 250, 525, 23);

        btnRank.setText("Leaderboard");
        btnRank.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRankMouseClicked(evt);
            }
        });
        jPanelMainMenu.add(btnRank);
        btnRank.setBounds(129, 284, 525, 23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMainMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMainMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Determine game mode (versus player)
     * @param evt 
     */
    private void radioPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioPlayerActionPerformed
        txtFieldPlayer2.setVisible(true);
        user1.setGamemode(2);
    }//GEN-LAST:event_radioPlayerActionPerformed
    /**
     * Determine game mode (versus computer)
     * @param evt 
     */
    private void radioComputerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioComputerActionPerformed
        txtFieldPlayer2.setVisible(false);
        user1.setGamemode(1);
    }//GEN-LAST:event_radioComputerActionPerformed
    /**
     * Exits the application
     * @param evt 
     */
    private void btnQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnQuitActionPerformed
    
    /**
     * Button used to move to settings scene
     * @param evt 
     */
    private void btnSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSettingsActionPerformed
        Settings s = new Settings(user1, user2);
        s.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnSettingsActionPerformed
    /**
     * Button used to move to game scene
     * @param evt 
     */
    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        System.out.println(user1.getColorScheme() + " " + user1.getWindowSize());
        Game s = new Game(user1, user2);   
        s.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnStartActionPerformed

    /**
     * Displays username of player 1
     * @param evt 
     */
    private void txtFieldPlayer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldPlayer1ActionPerformed
        user1.setUsername(this.txtFieldPlayer1.getText()); 
    }//GEN-LAST:event_txtFieldPlayer1ActionPerformed

    /**
     * Displays username of player 2
     * @param evt 
     */
    private void txtFieldPlayer2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldPlayer2ActionPerformed
        user2.setUsername(this.txtFieldPlayer1.getText()); 
    }//GEN-LAST:event_txtFieldPlayer2ActionPerformed

    /**
     * Grabs text of radio button, so that we can determine what the game modeis
     * @return return the text of the radio button (Player or Computer)
     */
    private String getRadioButton() {
        if (radioPlayer.isSelected()) {
            return radioPlayer.getText();
        } else {
            return radioComputer.getText();
        }
    }
    
    /**
     * Button used to move us to the User Profiles scene
     * @param evt 
     */
    private void btnProfilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfilesActionPerformed
        // TODO add your handling code here:
        UserProfiles s = new UserProfiles(user1, user2);     
        s.setVisible(true);  
        dispose();
    }//GEN-LAST:event_btnProfilesActionPerformed

    /**
     * Button used to move us to the high scores scene
     * @param evt 
     */
    private void btnRankMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRankMouseClicked
        // TODO add your handling code here:
        Rank_table ranking = new Rank_table(user1, user2);
        ranking.FileReader();
        ranking.addRowtoJtable();
        ranking.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRankMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGroupVersus;
    private javax.swing.JButton btnProfiles;
    private javax.swing.JButton btnQuit;
    private javax.swing.JButton btnRank;
    private javax.swing.JButton btnSettings;
    private javax.swing.JButton btnStart;
    private javax.swing.JPanel jPanelMainMenu;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblVersus;
    private javax.swing.JRadioButton radioComputer;
    private javax.swing.JRadioButton radioPlayer;
    private javax.swing.JTextField txtFieldPlayer1;
    private javax.swing.JTextField txtFieldPlayer2;
    // End of variables declaration//GEN-END:variables

}
