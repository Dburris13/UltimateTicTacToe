/*
 * CS321 - Java Programming
 * Final Project - Team 8 - Ultimate Tic-Tac-Toe
 * 
 * Members:
 * Daniel, Ben, Irene, Zach
 */
package PlayerInfo;

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
 * File I/O for userProfiles. 
 * This class extends our abstract FileManager class. 
 * He implements the read and write methods using BufferedReader FileOutput Stream.
 * 
 * @author Daniel
 */
public class FileProfile extends FileManager {
        private final String filePathString;
        private final File f;
    
        /**
         * Default Constructor.
         * Takes the name of user and attaches it to pathname based on our file
         * hierarchy. 
         * 
         * @param filename name of user 
         */
        public FileProfile(String filename) {       
            super(filename);
            filePathString = "userProfiles/" + filename;
            f = new File(filePathString);     
        }
        
        /**
         * Reading through file line by line and appends data to String array.
         * 
         * @return string array of all lines in file
         * @throws FileNotFoundException thrown if file does not exist
         * @throws IOException throw if file cannot be read or opened
         */
        @Override
        public String[] readFile() throws FileNotFoundException, IOException {
            List<String> lines = new ArrayList<>();
            if (f.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(f));
                String line = null;
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
            } else {
                if ("Computer AI".equals(filename)) {
                } else {
                    JOptionPane.showMessageDialog(null, "User Profile Not Found");
                }
            }
            return lines.toArray(new String[lines.size()]);
        }
        
        /**
         * Writing to file with FileOutputStream.
         * 
         * @param input what will be written to the file
         * @return true if successful false if failed
         * @throws FileNotFoundException thrown if file does not exist
         * @throws IOException thrown if file cannot be written to or closed
         */
        @Override
        public boolean writeFile(String input) throws FileNotFoundException, IOException {
            if (f.exists()){
                FileOutputStream fileOut = new FileOutputStream(filePathString);
                fileOut.write(input.getBytes());
                fileOut.close();
                return true;
            } else {
                return false;
            }
        }
}
