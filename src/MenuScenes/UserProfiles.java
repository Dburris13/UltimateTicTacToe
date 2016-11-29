/* 
 * CS321 - Java Programming
 * Final Project - Team 8 - Ultimate Tic-Tac-Toe
 * 
 * Members:
 * Daniel, Ben, Irene, Zach
 */
package MenuScenes;
import PlayerInfo.FileProfile;
import PlayerInfo.UserInfo;
import java.awt.Color;
import java.awt.Dimension;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 * This class represents our user profiles scene.
 * This class features a jList which contains all the current user profiles.
 * It has 2 jTextBoxes that load user profile statistics on load. It has 2 
 * load buttons that appear for each user to be loaded (only 1 button is visible
 * if versus computer is selected). It has a new button for creating a new user
 * profile. It also has a button to return us to the main menu.
 * 
 * @author Daniel
 */
public class UserProfiles extends javax.swing.JFrame {

    private UserInfo playerinfo1;
    private UserInfo playerinfo2;
    private DefaultListModel<String> userListModel;
    /**
     * Default Constructor.
     * 
     * Creates new form UserProfiles
     */
    public UserProfiles() {
        initComponents();
        this.setLocationRelativeTo(null);
        if (playerinfo1.getGamemode() == 1) {
        } else {
        
        }
    }
    
    /**
     * Constructor Method.
     * Takes in two user profiles as parameters.
     * 
     * @param user1 player 1
     * @param user2 player 2
     */
    public UserProfiles(UserInfo user1, UserInfo user2) {
        this.playerinfo1 = user1;
        this.playerinfo2 = user2;
        
        File upDir = new File("userProfiles");
        if (!upDir.exists()) {
            boolean result = false;
            
            try {
                upDir.mkdir();
                result = true;
            }
            catch(SecurityException se) {
            
            }
        }
        
        initComponents();
        this.setLocationRelativeTo(null);
        
        if (playerinfo1.getGamemode() == 1) {
            p2Lbl.setVisible(false);
            p2LoadBtn.setVisible(false);
            profileInfo2.setVisible(false);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        profilesList = new javax.swing.JList<>();
        p1LoadBtn = new javax.swing.JButton();
        p1NewBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        profileInfo2 = new javax.swing.JTextArea();
        returnBtn = new javax.swing.JButton();
        p1Lbl = new javax.swing.JLabel();
        p2Lbl = new javax.swing.JLabel();
        p2LoadBtn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        profileInfo1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        userListModel = new DefaultListModel<String>() {
            public String[] ReadDirectory() {
                String path = "userProfiles";

                String[] files = new String[10];
                File folder = new File(path);
                File[] listOfFiles = folder.listFiles();

                for (int i = 0; i < listOfFiles.length; i++) {
                    if (listOfFiles[i].isFile()) {
                        files[i] = listOfFiles[i].getName();
                    }
                }
                return files;
            }
            String[] strings = ReadDirectory();
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        };
        profilesList.setModel(userListModel);
        jScrollPane1.setViewportView(profilesList);

        p1LoadBtn.setText("Load User");
        p1LoadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p1LoadBtnActionPerformed(evt);
            }
        });

        p1NewBtn.setText("New User");
        p1NewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p1NewBtnActionPerformed(evt);
            }
        });

        profileInfo2.setColumns(20);
        profileInfo2.setRows(5);
        jScrollPane2.setViewportView(profileInfo2);

        returnBtn.setText("Return");
        returnBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnBtnActionPerformed(evt);
            }
        });

        p1Lbl.setText("Player 1:");

        p2Lbl.setText("Player 2:");

        p2LoadBtn.setText("Load User");
        p2LoadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p2LoadBtnActionPerformed(evt);
            }
        });

        profileInfo1.setColumns(20);
        profileInfo1.setRows(5);
        jScrollPane3.setViewportView(profileInfo1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(41, 41, 41)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(114, 114, 114)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(166, 166, 166)
                            .addComponent(returnBtn)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(p2Lbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(p2LoadBtn)
                                .addGap(85, 85, 85))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(p1Lbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(p1LoadBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(p1NewBtn)))
                        .addGap(93, 93, 93)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(p1LoadBtn)
                    .addComponent(p1NewBtn)
                    .addComponent(p1Lbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(p2LoadBtn)
                    .addComponent(p2Lbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(returnBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Player 1 Load Button.
     * This button allows player 1's user profile to be loaded.
     * Player 1's settings are used to determine game settings.
     * 
     * @param evt event listener
     */
    private void p1LoadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p1LoadBtnActionPerformed
        if (playerinfo1 != null) {
            String selected = profilesList.getSelectedValue();
            this.playerinfo1.setUsername(selected);
            FileProfile fh = new FileProfile(selected);
            String[] lines = null;
            try {
                lines = fh.readFile();
            } catch (IOException ex) {
                Logger.getLogger(UserProfiles.class.getName()).log(Level.SEVERE, null, ex);
            }

            profileInfo1.setText(null);

            /**
             * This switch statement interprets each line  in the userProfiles 
             * and makes actions based on those lines.
             */
            if (lines != null) {
                for (String line : lines) {
                    String[] parts = line.split(" ");
                    if (null != parts) {
                        switch (parts[0]) {
                            case "GamesPlayed:":
                                profileInfo1.append(line);
                                profileInfo1.append("\n");
                                break;
                            case "GamesWon:":
                                profileInfo1.append(line);
                                profileInfo1.append("\n");
                                break;
                            case "ScreenResolution:":
                                int w = Integer.parseInt(parts[1]);
                                int h = Integer.parseInt(parts[2]);
                                playerinfo1.setResolution(new Dimension(w,h));
                                playerinfo1.setWindowSize(w+"x"+h);
                                break;
                            case "ColorScheme:":
                                Color c1 = associateColor(parts[1]);
                                Color c2 = associateColor(parts[2]);
                                playerinfo1.setColor1(c1);
                                playerinfo1.setColor2(c2);
                                playerinfo1.setColorScheme(parts[1]+"/"+parts[2]);
                                break;
                            case "Icons:":
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_p1LoadBtnActionPerformed

    /**
     * Associate Color.
     * Takes in a string as an input, outputs the associated color.
     * 
     * @param str String of Color
     * @return Color of String
     */
    private Color associateColor(String str) {        
        if (null != str) switch (str) {
            case "Cyan":
                return Color.CYAN;
            case "Gray":
                return Color.GRAY;
            case "Blue":
                return Color.BLUE;
            case "Red":
                return Color.RED;
            case "Magenta":
                return Color.MAGENTA;
            case "Yellow":
                return Color.YELLOW;
            case "Orange":
                return Color.ORANGE;                
            case "Green":
                return Color.GREEN;                    
        }
        
        return null;
    }
    
    /**
     * Player 2 Load Button.
     * This button allows player 2's user profile to be loaded.
     * Player 2's settings are not used.
     * 
     * @param evt event listener
     */
    private void p2LoadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p2LoadBtnActionPerformed
        playerinfo1.setGamemode(2);
        if (playerinfo2 != null) {
            String selected = profilesList.getSelectedValue();
            this.playerinfo2.setUsername(selected);
            FileProfile fh = new FileProfile(selected);
            String[] lines = new String[6];
            try {
                lines = fh.readFile();
            } catch (IOException ex) {
                Logger.getLogger(UserProfiles.class.getName()).log(Level.SEVERE, null, ex);
            }

            profileInfo2.setText(null);

            for (int i = 0; i < lines.length; i++) {
                String[] parts = lines[i].split(" ");
                if (null != parts) switch (parts[0]) {
                    case "GamesPlayed:":
                        profileInfo2.append(lines[i]);
                        profileInfo2.append("\n");
                        break;
                    case "GamesWon:":                
                        profileInfo2.append(lines[i]);
                        profileInfo2.append("\n");
                        break;
                    case "ScreenResolution:":
                        int w = Integer.parseInt(parts[1]);
                        int h = Integer.parseInt(parts[2]);
                        playerinfo2.setResolution(new Dimension(w,h));
                        playerinfo2.setWindowSize(w+"x"+h);                        
                        break;
                    case "ColorScheme:": 
                        Color c1 = associateColor(parts[1]);
                        Color c2 = associateColor(parts[2]);
                        playerinfo2.setColor1(c1);
                        playerinfo2.setColor2(c2);
                        playerinfo2.setColorScheme(parts[1]+"/"+parts[2]);
                        break;
                    case "Icons:":
                        break;
                    default:
                        break;
                
                }
            }
        }
    }//GEN-LAST:event_p2LoadBtnActionPerformed

    /**
     * Return Button.
     * Takes us bake to the menu.
     * 
     * @param evt 
     */
    private void returnBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnBtnActionPerformed
        // TODO add your handling code here:
        MenuGUI s = new MenuGUI(playerinfo1, playerinfo2);
        s.setVisible(true);
        dispose();        
    }//GEN-LAST:event_returnBtnActionPerformed

    /**
     * New Button.
     * Creates a new user profile.
     * 
     * @param evt 
     */
    private void p1NewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p1NewBtnActionPerformed
        // TODO add your handling code here:
        String newname = (String)JOptionPane.showInputDialog(null, "Enter your username", "New Profile", JOptionPane.PLAIN_MESSAGE, null, null, "");

        Charset charset = Charset.forName("US-ASCII");
        String filePathString = "userProfiles/" + newname;
        Path file = Paths.get(filePathString);
        File f = new File(filePathString);
        
        if (f.exists()) {
            JOptionPane.showMessageDialog(null, "Profile already exists for : " + newname);
        } else {
            /**
             * Writing default information to file
             */
            if ("null".equals(newname) || "Computer AI".equals(newname) || "Guest".equals(newname) || "Guest2".equals(newname)) {
                JOptionPane.showMessageDialog(null, "Sorry! " + newname + " is not an available username!");
            } else {
                String firstLine = "GamesPlayed: 0\n";
                String secondLine = "GamesWon: 0\n";
                String thirdLine = "ScreenResolution: " + (int)playerinfo1.getResolution().getWidth() + " " + (int)playerinfo1.getResolution().getHeight() + "\n";
                String fourthLine = "ColorScheme: Blue Gray\n";
                String fifthLine = "Icons: X O\n";

                try (BufferedWriter writer = Files.newBufferedWriter(file, charset)) {
                    writer.write(firstLine, 0, firstLine.length());
                    writer.write(secondLine, 0, secondLine.length());
                    writer.write(thirdLine, 0, thirdLine.length());
                    writer.write(fourthLine, 0, fourthLine.length());
                    writer.write(fifthLine, 0, fifthLine.length());
                } catch (IOException x) {
                    System.err.format("IOException: %s%n", x);
                }
                UserProfiles s = new UserProfiles(playerinfo1, playerinfo2);
                s.setVisible(true);
                dispose();  
            } 
        }

        userListModel.addElement(newname);
        profilesList.setModel(userListModel);
        jScrollPane1.setViewportView(profilesList);
        profilesList.repaint();
        profilesList.revalidate();
    }//GEN-LAST:event_p1NewBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel p1Lbl;
    private javax.swing.JButton p1LoadBtn;
    private javax.swing.JButton p1NewBtn;
    private javax.swing.JLabel p2Lbl;
    private javax.swing.JButton p2LoadBtn;
    private javax.swing.JTextArea profileInfo1;
    private javax.swing.JTextArea profileInfo2;
    private javax.swing.JList<String> profilesList;
    private javax.swing.JButton returnBtn;
    // End of variables declaration//GEN-END:variables
}
