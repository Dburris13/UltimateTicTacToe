/*
 * CS321 - Java Programming
 * Final Project - Team 8 - Ultimate Tic-Tac-Toe
 * 
 * Members:
 * Daniel, Ben, Irene, Zach
 */
package Group8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class FileProfile extends FileManager {
        private final String filePathString;
        private final File f;
    
        public FileProfile(String filename) {       
            super(filename);
            filePathString = "userProfiles/" + filename;
            f = new File(filePathString);     
        }
        
        @Override
        public String[] readFile() {
            List<String> lines = new ArrayList<String>();
            if (f.exists()) {
                try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
                    String line = null;
                    while ((line = reader.readLine()) != null) {
                        lines.add(line);
                    }
                } catch (IOException x) {
                    System.err.format("IOException: %s%n", x);
                }            
            } else {
                if ("Computer AI".equals(filename)) {
                } else {
                    JOptionPane.showMessageDialog(null, "User Profile Not Found");
                }
            }
            return lines.toArray(new String[lines.size()]);
        }
        
        @Override
        public boolean writeFile(String input) throws FileNotFoundException, IOException {
            FileOutputStream fileOut = new FileOutputStream(filePathString);
            fileOut.write(input.getBytes());
            fileOut.close();
            return true;
        }
}
