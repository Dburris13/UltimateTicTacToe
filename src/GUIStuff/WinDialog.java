/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2016 Oracle and/or its affiliates. All rights reserved.
 *
 * Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 * Other names may be trademarks of their respective owners.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common
 * Development and Distribution License("CDDL") (collectively, the
 * "License"). You may not use this file except in compliance with the
 * License. You can obtain a copy of the License at
 * http://www.netbeans.org/cddl-gplv2.html
 * or nbbuild/licenses/CDDL-GPL-2-CP. See the License for the
 * specific language governing permissions and limitations under the
 * License.  When distributing the software, include this License Header
 * Notice in each file and include the License file at
 * nbbuild/licenses/CDDL-GPL-2-CP.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the GPL Version 2 section of the License file that
 * accompanied this code. If applicable, add the following below the
 * License Header, with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * If you wish your version of this file to be governed by only the CDDL
 * or only the GPL Version 2, indicate your decision by adding
 * "[Contributor] elects to include this software in this distribution
 * under the [CDDL or GPL Version 2] license." If you do not indicate a
 * single choice of license, a recipient has the option to distribute
 * your version of this file under either the CDDL, the GPL Version 2 or
 * to extend the choice of license to its licensees as provided above.
 * However, if you add GPL Version 2 code and therefore, elected the GPL
 * Version 2 license, then the option applies only if the new code is
 * made subject to such option by the copyright holder.
 *
 * Contributor(s):
 *
 * Portions Copyrighted 2016 Sun Microsystems, Inc.
 */
package GUIStuff;

import Group8.Game;
import MenuScenes.MenuGUI;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * A JDialog class to congratulate the player who won the game. 
 * @author Irene
 */
public class WinDialog extends JDialog {
    private javax.swing.JLabel fireworksGif;
    private javax.swing.JLabel congratsLabel;
    private javax.swing.JLabel playerName;
    private javax.swing.JLabel playerScore1;
    //private javax.swing.JLabel playerScore2;
    private javax.swing.JButton menuReturnBtn;
    
    /**
     * 
     * @param frame the JFrame to which the JDialog is relative to
     * @param game a reference to the Game class to access the UserProfiles/
     * settings used
     * @param winningPlayer the name of the player who won
     * @param winningScore the winning player's score
     */
    public WinDialog(JFrame frame, Game game, String winningPlayer, int winningScore){
        super(frame, true);
        fireworksGif = new javax.swing.JLabel();
        congratsLabel = new javax.swing.JLabel();
        playerName = new javax.swing.JLabel();
        playerScore1 = new javax.swing.JLabel();
        //playerScore2 = new javax.swing.JLabel();
        menuReturnBtn = new javax.swing.JButton();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(525, 525));
        getContentPane().setLayout(null);
        
        congratsLabel.setFont(new java.awt.Font("Tahoma",1,36));
        congratsLabel.setForeground(new java.awt.Color(255, 255, 0));
        congratsLabel.setText("Congratulations,");
        getContentPane().add(congratsLabel);
        congratsLabel.setBounds(100, 120, 310, 44);
        
        playerName.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        playerName.setForeground(new java.awt.Color(255, 255, 0));
        playerName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playerName.setText(winningPlayer+"!");
        getContentPane().add(playerName);
        playerName.setBounds(90, 200, 330, 110);
        
        playerScore1.setFont(new java.awt.Font("Tahoma", 1, 24));
        playerScore1.setForeground(new java.awt.Color(255, 255, 0));
        playerScore1.setText(winningPlayer + " score: " + winningScore);
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
        
        fireworksGif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/fireworks-animated-gif-23.gif"))); // NOI18N
        getContentPane().add(fireworksGif);
        fireworksGif.setBounds(0, 0, 500, 474);
        
        pack();
        setLocationRelativeTo(frame);
    }
    
    /**
     * Disposes of the finished game and returns the user to the menu.
     * @param evt 
     * @param game the game which is currently played/just finished
     */
    private void menuReturnBtnActionPerformed(java.awt.event.ActionEvent evt, Game game) {                                              
      //MenuGUI s = new MenuGUI();
      //s.setVisible(true);
      game.goToMenu();
    } 
}
