/* 
 * CS321 - Java Programming
 * Final Project - Team 8 - Ultimate Tic-Tac-Toe
 * 
 * Members:
 * Daniel, Ben, Irene, Zach
 */
package Group8;

/**
 * This class represents our settings scene.
 * This class features 3 combo boxes that allow the user to customize his game
 * settings. It has a button to return us to the menu. 
 * 
 * @author Daniel
 */
import MenuScenes.MenuGUI;
import java.awt.Color;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class represents our user settings scene.
 * It features 2 combo boxes that allow the user change game settings.
 * It features a button that returns us to the menu.
 * 
 * @author Daniel
 */
public class Settings extends javax.swing.JFrame {

    private UserInfo user1Settings;
    private UserInfo user2Settings;
    private String username;
    
    /**
     * Default Constructor.
     * 
     */
    public Settings() {
        initComponents();
    }
    
    /**
     * Constructor Method.
     * Takes in two user profiles as parameters.
     * 
     * @param param1 user 1 class
     * @param param2 user 2 class
     */
    public Settings(UserInfo param1, UserInfo param2) {
        this.user1Settings = param1;
        this.user2Settings = param2;
        initComponents();

        this.cbColor.setSelectedItem(param1.getColorScheme());
        this.cbScreen.setSelectedItem(param1.getWindowSize());
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
        
        btnReturn.setText("Return");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnReturnActionPerformed(evt);
                } catch (IOException ex) {
                    Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
                }
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
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addComponent(btnReturn)
                .addContainerGap())
        );

        pack();
        this.setLocationRelativeTo(null);
    }// </editor-fold>                        

    /**
     * Return Button.
     * Takes us bake to the menu.
     * 
     * @param evt 
     */
    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) throws IOException {                                          
        // TODO add your handling code here:
        if (user1Settings.getUsername() != "Guest") {
            FileHandler fh = new FileHandler(user1Settings.getUsername());
            String[] lines = new String[6];
            lines = fh.readStatistics();
            
            String input = "";
            for (int i = 0; i < lines.length; i++) {
                String[] parts = lines[i].split(" ");
                input += lines[i] + '\n';
                if (null != parts) switch (parts[0]) {
                    case "ScreenResolution:":       
                        int w = Integer.parseInt(parts[1]);
                        int h = Integer.parseInt(parts[2]);
                        input = input.replace("ScreenResolution: " + w + " " + h, "ScreenResolution: " + (int)user1Settings.getResolution().getWidth() + " " + (int)user1Settings.getResolution().getHeight());
                        break;
                    case "ColorScheme:": 
                        input = input.replace("ColorScheme: " + parts[1] + " " + parts[2], "ColorScheme: " + getColor1Value() + " " + getColor2Value());
                        break;
                    case "Icons:":
                        break;
                    default:
                        break;
                    }
                }
                fh.writeSettings(input);
            }
        
        MenuGUI s = new MenuGUI(user1Settings, user2Settings);
        s.setVisible(true);     
        dispose();
    }                  
    
    /**
     * Get Color 1.
     * Gets color 1 attribute from UserInfo object.
     * 
     * @return returns button color 1 
     */
    private String getColor1Value() {
        String colorStr = "";
        
        if (user1Settings.getColor1() == Color.BLUE) {
            return "Blue";
        } else if (user1Settings.getColor1() == Color.RED) {
            return "Red";
        } else if (user1Settings.getColor1() == Color.CYAN) {
            return "Cyan";
        } else if (user1Settings.getColor1() == Color.GRAY) {
            return "Gray";
        } else if (user1Settings.getColor1() == Color.MAGENTA) {
            return "Magenta";
        } else if (user1Settings.getColor1() == Color.YELLOW) {
            return "Yellow";
        } else if (user1Settings.getColor1() == Color.ORANGE) {
            return "Orange";
        } else if (user1Settings.getColor1() == Color.GREEN) {
            return "Green";
        }
        
        return colorStr;
    }
    
    /**
     * Get Color 2.
     * Gets color 2 attribute from UserInfo object.
     * 
     * @return returns button color 2 
     */    
    private String getColor2Value() {
        String colorStr = "";
        
        if (user1Settings.getColor2() == Color.BLUE) {
            return "Blue";
        } else if (user1Settings.getColor2() == Color.RED) {
            return "Red";
        } else if (user1Settings.getColor2() == Color.CYAN) {
            return "Cyan";
        } else if (user1Settings.getColor2() == Color.GRAY) {
            return "Gray";
        } else if (user1Settings.getColor2() == Color.MAGENTA) {
            return "Magenta";
        } else if (user1Settings.getColor2() == Color.YELLOW) {
            return "Yellow";
        } else if (user1Settings.getColor2() == Color.ORANGE) {
            return "Orange";
        } else if (user1Settings.getColor2() == Color.GREEN) {
            return "Green";
        }
        
        return colorStr;
    }
    
    /**
     * Screen Combo Box Action Performed.
     * Updated UserInfo when the combo box selection changes.
     * @param evt 
     */        
    private void cbScreenActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        String resolution = (String)cbScreen.getSelectedItem();
        if (null != resolution) switch (resolution) {
            case "1920x1080":
                user1Settings.setResolution(new Dimension(1920,1080));
                user1Settings.setWindowSize("1920x1080");
                break;
            case "1600x900":
                user1Settings.setResolution(new Dimension(1600,900));
                user1Settings.setWindowSize("1600x900");
                break;
            case "1280x720":
                user1Settings.setResolution(new Dimension(1280,720));
                user1Settings.setWindowSize("1280x720");
                break;
            case "1024x576":
                user1Settings.setResolution(new Dimension(1024,576));
                user1Settings.setWindowSize("1024x576");
                break;
            default:
                break;
        }
    }                                        

    /**
     * Color Combo Box Action Performed.
     * Updated UserInfo when the combo box selection changes.
     * @param evt 
     */
    private void cbColorActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        String colorScheme = (String)cbColor.getSelectedItem();
        if (null != colorScheme) switch (colorScheme) {
            case "Cyan/Gray":
                user1Settings.setColor1(Color.CYAN);
                user1Settings.setColor2(Color.GRAY);
                user1Settings.setColorScheme("Cyan/Gray");
                break;
            case "Blue/Red":
                user1Settings.setColor1(Color.BLUE);
                user1Settings.setColor2(Color.RED);
                user1Settings.setColorScheme("Blue/Red");
                break;
            case "Magenta/Yellow":
                user1Settings.setColor1(Color.MAGENTA);
                user1Settings.setColor2(Color.YELLOW); 
                user1Settings.setColorScheme("Magenta/Yellow");
                break;
            case "Orange/Green":
                user1Settings.setColor1(Color.ORANGE);
                user1Settings.setColor2(Color.GREEN);
                user1Settings.setColorScheme("Orange/Green");
                break;
            default:
                break;
        }
    }    

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnReturn;
    private javax.swing.JComboBox<String> cbColor;
    private javax.swing.JComboBox<String> cbScreen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration                   
}
