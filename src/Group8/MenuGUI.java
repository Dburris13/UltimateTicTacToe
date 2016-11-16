/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Group8;

import GUIStuff.AnimatedPanel;
import java.awt.Color;

/**
 *
 * @author kcnre
 */
public class MenuGUI extends javax.swing.JFrame {
 
    private UserInfo user1;
    private UserInfo user2;   

    /**
     * Creates new form MenuGUI
     * Called on game startup
     */
    public MenuGUI() {
       user1 = new UserInfo("Guest");
       user2 = new UserInfo("Guest2");  
       //Creates a jpanel that is behind the menu
       this.setContentPane(new AnimatedPanel());
       initComponents();
       //sets the background color
       this.getContentPane().setBackground(Color.decode( "#d4f4dd" )); 
       this.setLocationRelativeTo(null);
       this.PlayerRadioButton.setSelected(true);
       
       PlayerNameField1.setText(user1.getUsername());
       PlayerNameField2.setText(user2.getUsername());
       System.out.println(user1.getColorScheme() + " " + user1.getWindowSize());
    }
    
    /**
     * Creates new form MenuGUI
     * Called when switching back to menu after game is started
     * @param user
     */
    public MenuGUI(UserInfo param1, UserInfo param2) {
                //Creates a jpanel that is behind the menu
        this.user1 = param1;
        this.user2 = param2;
        
        this.setContentPane(new AnimatedPanel());
        initComponents();
        this.setLocationRelativeTo(null);
        //sets the background color  
        this.getContentPane().setBackground(Color.decode( "#d4f4dd" ));      
        
        
        if (user1.getGamemode() == 1) {
            this.ComputerRadioButton.setSelected(true);
            PlayerNameField2.setVisible(false);
            this.PlayerNameField1.setText(user1.getUsername());
        } else {
            this.PlayerRadioButton.setSelected(true);
            PlayerNameField2.setVisible(true);
            this.PlayerNameField1.setText(user1.getUsername());
            this.PlayerNameField2.setText(user2.getUsername());
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

        CompVPlayerGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        PlayerName1 = new javax.swing.JLabel();
        PlayerNameField1 = new javax.swing.JTextField();
        VersusLabel = new javax.swing.JLabel();
        btnStart = new javax.swing.JButton();
        btnSettings = new javax.swing.JButton();
        btnQuit = new javax.swing.JButton();
        ComputerRadioButton = new javax.swing.JRadioButton();
        PlayerNameField2 = new javax.swing.JTextField();
        PlayerRadioButton = new javax.swing.JRadioButton();
        btnProfiles = new javax.swing.JButton();
        btnRank = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setOpaque(false);

        titleLabel.setFont(new java.awt.Font("Tempus Sans ITC", 1, 48)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Ultimate TIC TAC TOE");

        PlayerName1.setText("User Name: ");

        PlayerNameField1.setText("Player1");
        PlayerNameField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayerNameField1ActionPerformed(evt);
            }
        });

        VersusLabel.setText("Versus:");

        btnStart.setText("Start Game");
        btnStart.setToolTipText("");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        btnSettings.setText("Settings");
        btnSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSettingsActionPerformed(evt);
            }
        });

        btnQuit.setText("Quit");
        btnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitActionPerformed(evt);
            }
        });

        CompVPlayerGroup.add(ComputerRadioButton);
        ComputerRadioButton.setText("Computer");
        ComputerRadioButton.setOpaque(false);
        ComputerRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComputerRadioButtonActionPerformed(evt);
            }
        });

        PlayerNameField2.setText("Player2");
        PlayerNameField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayerNameField2ActionPerformed(evt);
            }
        });

        CompVPlayerGroup.add(PlayerRadioButton);
        PlayerRadioButton.setText("Player");
        PlayerRadioButton.setMaximumSize(new java.awt.Dimension(103, 29));
        PlayerRadioButton.setMinimumSize(new java.awt.Dimension(103, 29));
        PlayerRadioButton.setOpaque(false);
        PlayerRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayerRadioButtonActionPerformed(evt);
            }
        });

        btnProfiles.setText("User Profiles");
        btnProfiles.setToolTipText("");
        btnProfiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfilesActionPerformed(evt);
            }
        });

        btnRank.setText("Leaderboard");
        btnRank.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRankMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(VersusLabel)
                        .addGap(77, 77, 77)
                        .addComponent(ComputerRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(PlayerName1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PlayerNameField1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PlayerRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PlayerNameField2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRank, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSettings, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(titleLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnQuit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProfiles, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(138, 138, 138))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(titleLabel)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PlayerNameField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PlayerNameField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PlayerName1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VersusLabel)
                    .addComponent(ComputerRadioButton)
                    .addComponent(PlayerRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(btnStart)
                .addGap(18, 18, 18)
                .addComponent(btnProfiles)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRank)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSettings)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnQuit)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PlayerRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayerRadioButtonActionPerformed
        PlayerNameField2.setVisible(true);
        user1.setGamemode(2);
    }//GEN-LAST:event_PlayerRadioButtonActionPerformed

    private void ComputerRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComputerRadioButtonActionPerformed
        PlayerNameField2.setVisible(false);
        user1.setGamemode(1);
    }//GEN-LAST:event_ComputerRadioButtonActionPerformed

    private void btnQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnQuitActionPerformed

    private void btnSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSettingsActionPerformed
        Settings s = new Settings(user1, user2);
        s.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnSettingsActionPerformed

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        System.out.println(user1.getColorScheme() + " " + user1.getWindowSize());
        Game s = new Game(user1, user2);   
        s.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnStartActionPerformed

    private void PlayerNameField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayerNameField1ActionPerformed
        user1.setUsername(this.PlayerNameField1.getText()); 
    }//GEN-LAST:event_PlayerNameField1ActionPerformed

    private void PlayerNameField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayerNameField2ActionPerformed
        user2.setUsername(this.PlayerNameField1.getText()); 
    }//GEN-LAST:event_PlayerNameField2ActionPerformed

    private String getRadioButton() {
        if (PlayerRadioButton.isSelected()) {
            return PlayerRadioButton.getText();
        } else {
            return ComputerRadioButton.getText();
        }
    }
    
    private void btnProfilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfilesActionPerformed
        // TODO add your handling code here:
        UserProfiles s = new UserProfiles(this, true, user1, user2);     
        s.setVisible(true);  
        dispose();
    }//GEN-LAST:event_btnProfilesActionPerformed

    private void btnRankMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRankMouseClicked
        // TODO add your handling code here:
        Rank_table ranking = new Rank_table(user1, user2);
        ranking.FileReader();
        ranking.addRowtoJtable();
        ranking.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRankMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup CompVPlayerGroup;
    private javax.swing.JRadioButton ComputerRadioButton;
    private javax.swing.JLabel PlayerName1;
    private javax.swing.JTextField PlayerNameField1;
    private javax.swing.JTextField PlayerNameField2;
    private javax.swing.JRadioButton PlayerRadioButton;
    private javax.swing.JLabel VersusLabel;
    private javax.swing.JButton btnProfiles;
    private javax.swing.JButton btnQuit;
    private javax.swing.JButton btnRank;
    private javax.swing.JButton btnSettings;
    private javax.swing.JButton btnStart;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables

}
