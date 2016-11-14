/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Group8;

/**
 *
 * @author Daniel
 */
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Settings extends javax.swing.JFrame {

    private UserInfo userInfo  = new UserInfo();
    private String username;
    
    public Settings() {
        initComponents();
        readUserProfile();
    }
    
    public Settings(String username) {
        this.username = username;
        
        initComponents();
        readUserProfile();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        
        jLabel1 = new javax.swing.JLabel();
        cbColor = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbScreen = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbIcons = new javax.swing.JComboBox<>();
        btnReturn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Color Schemes");

        cbColor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cyan/Gray", "Blue/Red", "Magenta/Yellow", "Orange/Green"  }));
        cbColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbColorActionPerformed(evt);
            }
        });

        jLabel2.setText("Screen Resolution");

        cbScreen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1920x1080", "1600x900", "1280x720", "1024x576" }));
        cbScreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbScreenActionPerformed(evt);
            }
        });

        jLabel3.setText("Icon Schemes");

        cbIcons.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbIcons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbIconsActionPerformed(evt);
            }
        });

        btnReturn.setText("Return");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbColor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(77, 77, 77)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbScreen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbIcons, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(btnReturn)))
                .addContainerGap(134, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbScreen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbIcons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addComponent(btnReturn)
                .addContainerGap())
        );

        pack();
        this.setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        if (userInfo.getUsername() != null) {
            FileHandler fh = new FileHandler(userInfo.getUsername());
            String[] lines = new String[6];
            lines = fh.readStatistics();
            
            for (int i = 0; i < lines.length; i++) {
                String[] parts = lines[i].split(" ");
                if (parts[i].matches("Resolution")) {
                    // Add code to print settings
                }
            }
            
        }
        
        MenuGUI s = new MenuGUI(userInfo, null);              //NEW MENU
        s.setVisible(true);     
        dispose();
    }                  
    
    private void cbScreenActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        String resolution = (String)cbScreen.getSelectedItem();
        if (null != resolution) switch (resolution) {
            case "1920x1080":
                userInfo.setResolution(new Dimension(1920,1080));
                break;
            case "1600x900":
                userInfo.setResolution(new Dimension(1600,900));
                break;
            case "1280x720":
                userInfo.setResolution(new Dimension(1280,720));
                break;
            case "1024x576":
                userInfo.setResolution(new Dimension(1024,576));
                break;
            default:
                break;
        }        
    }                                        

    private void cbIconsActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                   

    private void cbColorActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        String colorScheme = (String)cbColor.getSelectedItem();
        if (null != colorScheme) switch (colorScheme) {
            case "Cyan/Gray":
                userInfo.setColor1(Color.CYAN);
                userInfo.setColor2(Color.GRAY);
                break;
            case "Blue/Red":
                userInfo.setColor1(Color.BLUE);
                userInfo.setColor2(Color.RED);
                break;
            case "Magenta/Yellow":
                userInfo.setColor1(Color.MAGENTA);
                userInfo.setColor2(Color.YELLOW); 
                break;
            case "Orange/Green":
                userInfo.setColor1(Color.ORANGE);
                userInfo.setColor2(Color.GREEN);
                break;
            default:
                break;
        }
    }    

    private void readUserProfile() {
// Once the user has entered his username, it will create or read his profile
        Charset charset = Charset.forName("US-ASCII");
        String filePathString = "userProfiles/" + username + "profile";
        Path file = Paths.get(filePathString);
        File f = new File(filePathString);
        
        if (f.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException x) {
                System.err.format("IOException: %s%n", x);
            }
        } 
    }
    
    // Variables declaration - do not modify                     
    private javax.swing.JButton btnReturn;
    private javax.swing.JComboBox<String> cbColor;
    private javax.swing.JComboBox<String> cbIcons;
    private javax.swing.JComboBox<String> cbScreen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration                   
}
